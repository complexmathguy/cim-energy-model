import React, { Component } from 'react'
import ThermalGeneratingUnitService from '../services/ThermalGeneratingUnitService'

class ViewThermalGeneratingUnitComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            thermalGeneratingUnit: {}
        }
    }

    componentDidMount(){
        ThermalGeneratingUnitService.getThermalGeneratingUnitById(this.state.id).then( res => {
            this.setState({thermalGeneratingUnit: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View ThermalGeneratingUnit Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewThermalGeneratingUnitComponent
