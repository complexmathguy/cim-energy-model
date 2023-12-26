import React, { Component } from 'react'
import BusbarSectionService from '../services/BusbarSectionService'

class ViewBusbarSectionComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            busbarSection: {}
        }
    }

    componentDidMount(){
        BusbarSectionService.getBusbarSectionById(this.state.id).then( res => {
            this.setState({busbarSection: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View BusbarSection Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> ipMax:&emsp; </label>
                            <div> { this.state.busbarSection.ipMax }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewBusbarSectionComponent
