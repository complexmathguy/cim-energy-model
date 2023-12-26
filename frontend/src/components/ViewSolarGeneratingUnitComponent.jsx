import React, { Component } from 'react'
import SolarGeneratingUnitService from '../services/SolarGeneratingUnitService'

class ViewSolarGeneratingUnitComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            solarGeneratingUnit: {}
        }
    }

    componentDidMount(){
        SolarGeneratingUnitService.getSolarGeneratingUnitById(this.state.id).then( res => {
            this.setState({solarGeneratingUnit: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View SolarGeneratingUnit Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewSolarGeneratingUnitComponent
