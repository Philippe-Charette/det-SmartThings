/**
 *  Orvibo T10S7ZW 7 Button Scene Controller
 *
 *	Author: Brad Sutton based
 *	Date Created: 2018-01-11
 *  Last Updated: 2019-11-27
 *
 *  Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 *  in compliance with the License. You may obtain a copy of the License at:
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software distributed under the License is distributed
 *  on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License
 *  for the specific language governing permissions and limitations under the License.
 *
 
 *Raw Description:
	* 01	EndpointId
	* 0104	ProfileID for ZigBee HA
	* 000C	DeviceID
	* 00		*********
	* 02		Denotes 2 IN(Server) Clusters
	* 0000	Basic Cluster
	* 0005	Scenes Cluster
	**03	Denotes 3 OUT(Client) Clusters
	* 0000	Basic Cluster
	* 0005	Scenes Cluster
	* 0017	AlphaSecureKeyEstablishment Cluster

	* Command reference
	* All buttons support pressed / held / released
	* 1 pressed	 'catchall: 0104 0017 01 0A 0100 00 4348 01 00 0000 08 01 010000'
	* 2 pressed	 'catchall: 0104 0017 01 0A 0100 00 4348 01 00 0000 08 01 020000'
	* 3 pressed  'catchall: 0104 0017 01 0A 0100 00 4348 01 00 0000 08 01 030000'
	* 4 pressed  'catchall: 0104 0017 01 0A 0100 00 4348 01 00 0000 08 01 040000'
	* 5 pressed  'catchall: 0104 0017 01 0A 0100 00 4348 01 00 0000 08 01 050000'
	* 6 pressed  'catchall: 0104 0017 01 0A 0100 00 4348 01 00 0000 08 01 060000'
	* 7 pressed  'catchall: 0104 0017 01 0A 0100 00 4348 01 00 0000 08 01 070000'
	* 7 held	 'catchall: 0104 0017 01 0A 0100 00 4348 01 00 0000 08 01 070002'
	* 7 released 'catchall: 0104 0017 01 0A 0100 00 4348 01 00 0000 08 01 070003'
*/

metadata {
	definition (name: "Orvibo 7 Button Scene Controller (T10S7ZW)", namespace: "bradlee-s", author: "Bradlee Sutton") {
		capability "Actuator"
		capability "Button"
		capability "Configuration"
        capability "Execute"
		capability "Holdable Button"
		capability "Indicator"
		capability "Polling"
		capability "Refresh"
		capability "Sensor"
        capability "Switch"
        capability "Switch Level"
		
        attribute "currentButton", "STRING"
        attribute "numberOfButtons", "STRING"
		attribute "ButtonPressType", "ENUM", ["Held", "Pushed"]
        attribute "Indicator1", "ENUM", ["OFF", "ON", "OFFHELD", "ONHELD"]
        attribute "Indicator2", "ENUM", ["OFF", "ON", "OFFHELD", "ONHELD"]
        attribute "Indicator3", "ENUM", ["OFF", "ON", "OFFHELD", "ONHELD"]
        attribute "Indicator4", "ENUM", ["OFF", "ON", "OFFHELD", "ONHELD"]
        attribute "Indicator5", "ENUM", ["OFF", "ON", "OFFHELD", "ONHELD"]
        attribute "Indicator6", "ENUM", ["OFF", "ON", "OFFHELD", "ONHELD"]
        attribute "Indicator7", "ENUM", ["OFF", "ON", "OFFHELD", "ONHELD"]
        attribute "IndDisplay", "STRING"
		
		command "configure"
		command "refresh"
		command "buttonPressed"
		command "buttonPress1"
		command "buttonPress2"
		command "buttonPress3"
		command "buttonPress4"
		command "buttonPress5"
		command "buttonPress6"
		command "buttonPress7"
        command "getClusters"
		command "getInfo"
		command "installed"
		command "poll"
		command "toggle"
		
		fingerprint profileId: "0104",
			deviceId: "000C",
			inClusters: "0000, 0005",
			outClusters: "0000, 0005, 0017",
			manufacturer: "欧瑞博",
			model: "75d430d66c164c26ac8601c05932dc94",
			deviceJoinName: "Orvibo 7 Button Scene Controller"
	}

	tiles(scale: 2) {
		standardTile("button1", "device.Indicator1", inactiveLabel: false, width: 6, height: 4) {
			state "default", label: "OFF", action: "buttonPress1", icon:"st.switches.light.off", backgroundColor: "#ffffff", nextState: "ON", decoration: "flat"
			state "OFF", label: "OFF", action: "buttonPress1", icon:"st.switches.light.off", backgroundColor: "#ffffff", nextState: "ON", decoration: "flat"
			state "ON", label: "ON", action: "buttonPress1", icon:"st.switches.light.on", backgroundColor: "#79b821", nextState: "OFF", decoration: "flat"
            state "OFFHELD", label:'HOLDING', icon:"st.switches.light.off", backgroundColor:"#00a0dc", nextState: "OFF", decoration: "flat"
            state "ONHELD", label:'HOLDING', icon:"st.switches.light.on", backgroundColor:"#00a0dc", nextState: "ON", decoration: "flat"
  		}
		standardTile("button2", "device.Indicator2", inactiveLabel: false, width: 3, height: 2) {
			state "default", label: "OFF", action: "buttonPress2", icon:"st.switches.light.off", backgroundColor: "#ffffff", nextState: "ON", decoration: "flat"
			state "OFF", label: "OFF", action: "buttonPress2", icon:"st.switches.light.off", backgroundColor: "#ffffff", nextState: "ON", decoration: "flat"
			state "ON", label: "ON", action: "buttonPress2", icon:"st.switches.light.on", backgroundColor: "#79b821", nextState: "OFF", decoration: "flat"
            state "OFFHELD", label:'HOLDING', icon:"st.switches.light.off", backgroundColor:"#00a0dc", nextState: "OFF", decoration: "flat"
            state "ONHELD", label:'HOLDING', icon:"st.switches.light.on", backgroundColor:"#00a0dc", nextState: "ON", decoration: "flat"
  		}
		standardTile("button3", "device.Indicator3", inactiveLabel: false, width: 3, height: 2) {
			state "default", label: "OFF", action: "buttonPress3", icon:"st.switches.light.off", backgroundColor: "#ffffff", nextState: "ON", decoration: "flat"
			state "OFF", label: "OFF", action: "buttonPress3", icon:"st.switches.light.off", backgroundColor: "#ffffff", nextState: "ON", decoration: "flat"
			state "ON", label: "ON", action: "buttonPress3", icon:"st.switches.light.on", backgroundColor: "#79b821", nextState: "OFF", decoration: "flat"
            state "OFFHELD", label:'HOLDING', icon:"st.switches.light.off", backgroundColor:"#00a0dc", nextState: "OFF", decoration: "flat"
            state "ONHELD", label:'HOLDING', icon:"st.switches.light.on", backgroundColor:"#00a0dc", nextState: "ON", decoration: "flat"
  		}
		standardTile("button4", "device.Indicator4", inactiveLabel: false, width: 3, height: 2) {
			state "default", label: "OFF", action: "buttonPress4", icon:"st.switches.light.off", backgroundColor: "#ffffff", nextState: "ON", decoration: "flat"
			state "OFF", label: "OFF", action: "buttonPress4", icon:"st.switches.light.off", backgroundColor: "#ffffff", nextState: "ON", decoration: "flat"
			state "ON", label: "ON", action: "buttonPress4", icon:"st.switches.light.on", backgroundColor: "#79b821", nextState: "OFF", decoration: "flat"
            state "OFFHELD", label:'HOLDING', icon:"st.switches.light.off", backgroundColor:"#00a0dc", nextState: "OFF", decoration: "flat"
            state "ONHELD", label:'HOLDING', icon:"st.switches.light.on", backgroundColor:"#00a0dc", nextState: "ON", decoration: "flat"
  		}
		standardTile("button5", "device.Indicator5", inactiveLabel: false, width: 3, height: 2) {
			state "default", label: "OFF", action: "buttonPress5", icon:"st.switches.light.off", backgroundColor: "#ffffff", nextState: "ON", decoration: "flat"
			state "OFF", label: "OFF", action: "buttonPress5", icon:"st.switches.light.off", backgroundColor: "#ffffff", nextState: "ON", decoration: "flat"
			state "ON", label: "ON", action: "buttonPress5", icon:"st.switches.light.on", backgroundColor: "#79b821", nextState: "OFF", decoration: "flat"
            state "OFFHELD", label:'HOLDING', icon:"st.switches.light.off", backgroundColor:"#00a0dc", nextState: "OFF", decoration: "flat"
            state "ONHELD", label:'HOLDING', icon:"st.switches.light.on", backgroundColor:"#00a0dc", nextState: "ON", decoration: "flat"
  		}
		standardTile("button6", "device.Indicator6", inactiveLabel: false, width: 3, height: 2) {
			state "default", label: "OFF", action: "buttonPress6", icon:"st.switches.light.off", backgroundColor: "#ffffff", nextState: "ON", decoration: "flat"
			state "OFF", label: "OFF", action: "buttonPress6", icon:"st.switches.light.off", backgroundColor: "#ffffff", nextState: "ON", decoration: "flat"
			state "ON", label: "ON", action: "buttonPress6", icon:"st.switches.light.on", backgroundColor: "#79b821", nextState: "OFF", decoration: "flat"
            state "OFFHELD", label:'HOLDING', icon:"st.switches.light.off", backgroundColor:"#00a0dc", nextState: "OFF", decoration: "flat"
            state "ONHELD", label:'HOLDING', icon:"st.switches.light.on", backgroundColor:"#00a0dc", nextState: "ON", decoration: "flat"
  		}
		standardTile("button7", "device.Indicator7", inactiveLabel: false, width: 3, height: 2) {
			state "default", label: "OFF", action: "buttonPress7", icon:"st.switches.light.off", backgroundColor: "#ffffff", nextState: "ON", decoration: "flat"
			state "OFF", label: "OFF", action: "buttonPress7", icon:"st.switches.light.off", backgroundColor: "#ffffff", nextState: "ON", decoration: "flat"
			state "ON", label: "ON", action: "buttonPress7", icon:"st.switches.light.on", backgroundColor: "#79b821", nextState: "OFF", decoration: "flat"
            state "OFFHELD", label:'HOLDING', icon:"st.switches.light.off", backgroundColor:"#00a0dc", nextState: "OFF", decoration: "flat"
            state "ONHELD", label:'HOLDING', icon:"st.switches.light.on", backgroundColor:"#00a0dc", nextState: "ON", decoration: "flat"
  		}
		standardTile("refresh", "device.refresh", inactiveLabel: false, decoration: "flat", width: 2, height: 2) {
			state "default", label: "", action: "refresh.refresh", icon:"st.secondary.refresh"
  		}
		standardTile("configure", "device.configure", inactiveLabel: false, decoration: "flat", width: 2, height: 2) {
			state "configure", label: "", action: "configuration.configure", icon:"st.secondary.configure"
  		}
    	standardTile("Indicators", "device.IndDisplay", width: 2, height: 2) {
			state '${currentValue}', label:'${currentValue}', icon: "st.unknown.zwave.static-controller", backgroundColor:"#ffffff"
		}
        
		main "Indicators"
		details (["button1", "button2", "button3", "button4", "button5", "button6", "button7", "refresh", "configure", "Indicators"])	
  }
}

// Parse Events Into Attributes
def parse(String description) {
	//log.debug "Parsing '${description}'"
    def event = zigbee.parse(description)
    def dat = event.data
	
	//ignoring all other events. button action event.data will look like [(1-7), (0), (0,2,3)]
	if(dat[0] != null && dat[1] != null && dat[2] != null && dat[0] <= 7 && dat[1] == 0 && dat[2] <= 3) {
    	def btnNum = 1
		
		//reverse order of buttons so large top button is #1
		if(dat[0] == 7) {btnNum = 1}
		else if(dat[0] == 6) {btnNum = 2}
		else if(dat[0] == 5) {btnNum = 3}
		else if(dat[0] == 4) {btnNum = 4}
		else if(dat[0] == 3) {btnNum = 5}
		else if(dat[0] == 2) {btnNum = 6}
		else if(dat[0] == 1) {btnNum = 7}
		
        def btnAction = "";
        if(dat[2] == 0) {
        	buttonPressed(btnNum, "Indicator"+btnNum)
        	btnAction = "pressed"
        }
        else if(dat[2] == 2) {
        	buttonHeld(btnNum, "Indicator"+btnNum)
        	btnAction = "held"
        }
        else if(dat[2] == 3) {
        	buttonReleased(btnNum, "Indicator"+btnNum)
        	btnAction = "released"
        }
        
		//log.debug "Button'${dat[0]}' $btnAction"
	}
    
    /*
	log.debug zigbee.parseDescriptionAsMap(description)    
    
    Map map = [:]
    if (description?.startsWith('catchall:')) {
		map = parseCatchAllMessage(description)
	}
    
    def result = map ? createEvent(map) : null
	    
    if (description?.startsWith('enroll request')) {
		List cmds = enrollResponse()
		log.debug "enroll response: ${cmds}"
		result = cmds?.collect { new physicalgraph.device.HubAction(it) }
	}
	else if (description?.startsWith('read attr -')) {
		result = parseReportAttributeMessage(description).each { createEvent(it) }
	}
    */


    return result
}


// Update State - Store mode and settings
def updateState(String name, String value) {
  state[name] = value
  device.updateDataValue(name, value)
}


def refresh() {
    log.debug "Starting Refresh - not actually doing anything"
	
}


// Currently Empty
def poll() {

}


def configure() {
	log.debug "Running Configure for Orvibo Scene Controller..."
    
	log.debug "Setting numberOfButtons to 7"
	sendEvent(name: "numberOfButtons", value: 7, displayed: false)

    log.debug "Setting status of all Indicators to OFF"
    state["Indicator1"] = "OFF"
    state["Indicator2"] = "OFF"
    state["Indicator3"] = "OFF"
    state["Indicator4"] = "OFF"
    state["Indicator5"] = "OFF"
    state["Indicator6"] = "OFF"
    state["Indicator7"] = "OFF"
    
	refresh()
    
//    log.debug "Confuguring Reporting and Bindings."
//    fireCommands(zigbee.onOffConfig() + zigbee.levelConfig() + zigbee.onOffRefresh() + zigbee.levelRefresh() + zigbee.readAttribute(0x0000, 0x0005))
//    fireCommands(zigbee.onOffConfig() + zigbee.levelConfig() + zigbee.onOffRefresh() + zigbee.levelRefresh() + zigbee.readAttribute(0x0005, 0x0000))

/*
0x00 Add Scene				: GroupID(uint16), SceneID(uint8), TransitionTime(uint16), SceneName(string)
0x01 View Scene				: GroupID(uint16), SceneID(uint8)
0x02 Remove Scene			: GroupID(uint16), SceneID(uint8)
0x03 Remove All Scenes		: GroupID(uint16)
0x04 Store Scene			: GroupID(uint16), SceneID(uint8) : adds scene plus adds extension field sets with current states of all other clusters on the device
0x05 Recall Scene			: GroupID(uint16), SceneID(uint8)
0x06 Get Scene Membership	: GroupID(uint16)
0x40 Enhanced Add Scene		:
0x41 Enhanced View Scene	: optional - not supported
0x42 Copy Scene				:


    //log.debug "Configure Reporting on Scene Count"
    //cluster, attribute, datatype, mintime, maxtime, configurable change

    fireCommands(zigbee.onOffConfig() + zigbee.onOffRefresh() + zigbee.configureReporting(0x0005, 0x0000, 0x08, 0, 600, null) + "delay 500")
    zigbee.onOffConfig()
    zigbee.onOffRefresh()
    zigbee.configureReporting(0x0005, 0x0000, 0x08, 0, 600, null)
*/
}


def enrollResponse() {
	log.debug "Sending enroll response" [        
		"raw 0x500 {01 23 00 00 00}", "delay 200",
		"send 0x${device.deviceNetworkId} 0x01 1"
    ]
}


private fireCommands(List commands) {
	if (commands != null && commands.size() > 0) {
		//log.trace("Executing commands-- state:" + state + " commands:" + commands)
		for (String value : commands) {
			sendHubCommand([value].collect {new physicalgraph.device.HubAction(it)
			})
		}
	}
}

def buttonPress1() { buttonPressed(1, "Indicator1") }
def buttonPress2() { buttonPressed(2, "Indicator2") }
def buttonPress3() { buttonPressed(3, "Indicator3") }
def buttonPress4() { buttonPressed(4, "Indicator4") }
def buttonPress5() { buttonPressed(5, "Indicator5") }
def buttonPress6() { buttonPressed(6, "Indicator6") }
def buttonPress7() { buttonPressed(7, "Indicator7") }
def buttonPressed(btnNumber, obj) {
	//Toggle value of Indicator
	if(state[obj] != "ON") { state[obj] = "ON" }
	else { state[obj] = "OFF" }
    def currState = state[obj]
    log.debug "Button$btnNumber Pressed - Current State: $currState"
    
    sendEvent(name: "button", value: "pushed", data: [buttonNumber: btnNumber], descriptionText: "Button$btnNumber pressed on $device.displayName", isStateChange: true, type: "digital")
}

def buttonHeld(btnNumber, obj) {
	//Toggle value of Indicator
	if(state[obj] == "ON") { state[obj] = "ONHELD" }
	else { state[obj] = "OFFHELD" }
    def currState = state[obj]
    log.debug "Button$btnNumber Held - Current State: $currState"

	sendEvent(name: "button", value: "held", data: [buttonNumber: btnNumber], descriptionText: "Button$btnNumber held on $device.displayName", isStateChange: true, type: "digital")
}
def buttonReleased(btnNumber, obj) {
	//Toggle value of Indicator
	if(state[obj] == "ONHELD") { state[obj] = "ON" }
	else { state[obj] = "OFF" }
    def currState = state[obj]
    log.debug "Button$btnNumber Released - Current State: $currState"
}