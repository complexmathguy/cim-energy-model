import React, { Component } from 'react'
import DCConductingEquipmentService from '../services/DCConductingEquipmentService'

class ViewDCConductingEquipmentComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            dCConductingEquipment: {}
        }
    }

    componentDidMount(){
        DCConductingEquipmentService.getDCConductingEquipmentById(this.state.id).then( res => {
            this.setState({dCConductingEquipment: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View DCConductingEquipment Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewDCConductingEquipmentComponent
