import React, { Component } from 'react'
import EquipmentService from '../services/EquipmentService'

class ViewEquipmentComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            equipment: {}
        }
    }

    componentDidMount(){
        EquipmentService.getEquipmentById(this.state.id).then( res => {
            this.setState({equipment: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View Equipment Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewEquipmentComponent
