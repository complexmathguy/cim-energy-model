import React, { Component } from 'react'
import HydroGeneratingUnitService from '../services/HydroGeneratingUnitService'

class ViewHydroGeneratingUnitComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            hydroGeneratingUnit: {}
        }
    }

    componentDidMount(){
        HydroGeneratingUnitService.getHydroGeneratingUnitById(this.state.id).then( res => {
            this.setState({hydroGeneratingUnit: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View HydroGeneratingUnit Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> energyConversionCapability:&emsp; </label>
                            <div> { this.state.hydroGeneratingUnit.energyConversionCapability }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewHydroGeneratingUnitComponent
