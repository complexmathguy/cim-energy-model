import React, { Component } from 'react'
import EquipmentContainerService from '../services/EquipmentContainerService'

class ViewEquipmentContainerComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            equipmentContainer: {}
        }
    }

    componentDidMount(){
        EquipmentContainerService.getEquipmentContainerById(this.state.id).then( res => {
            this.setState({equipmentContainer: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View EquipmentContainer Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewEquipmentContainerComponent
