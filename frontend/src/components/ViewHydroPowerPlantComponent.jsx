import React, { Component } from 'react'
import HydroPowerPlantService from '../services/HydroPowerPlantService'

class ViewHydroPowerPlantComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            hydroPowerPlant: {}
        }
    }

    componentDidMount(){
        HydroPowerPlantService.getHydroPowerPlantById(this.state.id).then( res => {
            this.setState({hydroPowerPlant: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View HydroPowerPlant Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> hydroPlantStorageType:&emsp; </label>
                            <div> { this.state.hydroPowerPlant.hydroPlantStorageType }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewHydroPowerPlantComponent
