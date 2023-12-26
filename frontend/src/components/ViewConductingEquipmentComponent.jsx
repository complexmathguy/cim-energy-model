import React, { Component } from 'react'
import ConductingEquipmentService from '../services/ConductingEquipmentService'

class ViewConductingEquipmentComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            conductingEquipment: {}
        }
    }

    componentDidMount(){
        ConductingEquipmentService.getConductingEquipmentById(this.state.id).then( res => {
            this.setState({conductingEquipment: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View ConductingEquipment Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewConductingEquipmentComponent
