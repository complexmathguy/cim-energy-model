import React, { Component } from 'react'
import DCEquipmentContainerService from '../services/DCEquipmentContainerService'

class ViewDCEquipmentContainerComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            dCEquipmentContainer: {}
        }
    }

    componentDidMount(){
        DCEquipmentContainerService.getDCEquipmentContainerById(this.state.id).then( res => {
            this.setState({dCEquipmentContainer: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View DCEquipmentContainer Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewDCEquipmentContainerComponent
