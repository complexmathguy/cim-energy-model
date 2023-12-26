import React, { Component } from 'react'
import BusNameMarkerService from '../services/BusNameMarkerService'

class ViewBusNameMarkerComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            busNameMarker: {}
        }
    }

    componentDidMount(){
        BusNameMarkerService.getBusNameMarkerById(this.state.id).then( res => {
            this.setState({busNameMarker: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View BusNameMarker Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> priority:&emsp; </label>
                            <div> { this.state.busNameMarker.priority }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewBusNameMarkerComponent
