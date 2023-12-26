import React, { Component } from 'react'
import EquivalentEquipmentService from '../services/EquivalentEquipmentService'

class ViewEquivalentEquipmentComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            equivalentEquipment: {}
        }
    }

    componentDidMount(){
        EquivalentEquipmentService.getEquivalentEquipmentById(this.state.id).then( res => {
            this.setState({equivalentEquipment: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View EquivalentEquipment Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewEquivalentEquipmentComponent
