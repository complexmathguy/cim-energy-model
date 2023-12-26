import React, { Component } from 'react'
import EquipmentContainerService from '../services/EquipmentContainerService';

class CreateEquipmentContainerComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
        }
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            EquipmentContainerService.getEquipmentContainerById(this.state.id).then( (res) =>{
                let equipmentContainer = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateEquipmentContainer = (e) => {
        e.preventDefault();
        let equipmentContainer = {
                equipmentContainerId: this.state.id,
            };
        console.log('equipmentContainer => ' + JSON.stringify(equipmentContainer));

        // step 5
        if(this.state.id === '_add'){
            equipmentContainer.equipmentContainerId=''
            EquipmentContainerService.createEquipmentContainer(equipmentContainer).then(res =>{
                this.props.history.push('/equipmentContainers');
            });
        }else{
            EquipmentContainerService.updateEquipmentContainer(equipmentContainer).then( res => {
                this.props.history.push('/equipmentContainers');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/equipmentContainers');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add EquipmentContainer</h3>
        }else{
            return <h3 className="text-center">Update EquipmentContainer</h3>
        }
    }
    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                {
                                    this.getTitle()
                                }
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateEquipmentContainer}>Save</button>
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

export default CreateEquipmentContainerComponent
