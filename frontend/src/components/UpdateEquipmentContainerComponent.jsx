import React, { Component } from 'react'
import EquipmentContainerService from '../services/EquipmentContainerService';

class UpdateEquipmentContainerComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateEquipmentContainer = this.updateEquipmentContainer.bind(this);

    }

    componentDidMount(){
        EquipmentContainerService.getEquipmentContainerById(this.state.id).then( (res) =>{
            let equipmentContainer = res.data;
            this.setState({
            });
        });
    }

    updateEquipmentContainer = (e) => {
        e.preventDefault();
        let equipmentContainer = {
            equipmentContainerId: this.state.id,
        };
        console.log('equipmentContainer => ' + JSON.stringify(equipmentContainer));
        console.log('id => ' + JSON.stringify(this.state.id));
        EquipmentContainerService.updateEquipmentContainer(equipmentContainer).then( res => {
            this.props.history.push('/equipmentContainers');
        });
    }


    cancel(){
        this.props.history.push('/equipmentContainers');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update EquipmentContainer</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateEquipmentContainer}>Save</button>
                                        <button className="btn btn-danger" onClick={this.cancel.bind(this)} style={{marginLeft: "10px"}}>Cancel</button>
                                    </form>
                                </div>
                            </div>
                        </div>

                   </div>
            </div>
        )
    }
}

export default UpdateEquipmentContainerComponent
