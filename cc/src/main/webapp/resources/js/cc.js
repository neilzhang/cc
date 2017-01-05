var roomId;

function init() {

}

function createAndJoin() {
	var roomName = $("#room_name").val().trim();
	var roomDescription = $("#room_description").val().trim();
	if (!roomName)
		return;

	var param = {
		'name' : roomName,
		'description' : roomDescription
	};
	$.post("chatroom/create", param, function(data, textStatus, jqXHR) {
		if (data.code == "ACK") {
			roomId = data.data;
			joinRoom(roomId);
		}
	}, "json");
}

function join() {
	var searchName = $("#search_name").val().trim();
	if (!searchName)
		return;

	var param = {
		'name' : searchName
	};
	$.post("chatroom/getRoom", param, function(data, textStatus, jqXHR) {
		if (data.code == "ACK") {
			roomId = data.data.id;
			joinRoom(roomId);
		}
	}, "json");

}

function joinRoom(roomId) {
	if (!roomId) {
		return;
	}

	var param = {
		'roomId' : roomId,
		'clientId' : JS.Engine.getId()
	};
	$.post("chatroom/join", param, function(data, textStatus, jqXHR) {
		if (data.code == "ACK") {
			JS.Engine.on(roomId, function(message) {
				console.log(message.text);
			});
			JS.Engine.start('conn');
		}
	}, "json");

}

function send() {
	if (!JS.Engine.running)
		return;
	var text = $("#input_message").val().trim();
	if (!text || !roomId)
		return;

	var param = {
		'message' : text,
		'clientId' : JS.Engine.getId(),
		'roomId' : roomId
	};
	$.post("message/say", param, function(data, textStatus, jqXHR) {

	}, "json");
}

String.prototype.HTMLEncode = function() {
	var temp = document.createElement("div");
	(temp.textContent != null) ? (temp.textContent = this)
			: (temp.innerText = this);
	var output = temp.innerHTML;
	temp = null;
	return output;
};

String.prototype.HTMLDecode = function() {
	var temp = document.createElement("div");
	temp.innerHTML = this;
	var output = temp.innerText || temp.textContent;
	temp = null;
	return output;
};

String.prototype.trim = function() {
	return this.replace(/^\s+|\s+$/g, '');
};