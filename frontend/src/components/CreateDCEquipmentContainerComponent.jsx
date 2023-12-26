import React, { Component } from 'react'
import DCEquipmentContainerService from '../services/DCEquipmentContainerService';

class CreateDCEquipmentContainerComponent extends Component {
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
            DCEquipmentContainerService.getDCEquipmentContainerById(this.state.id).then( (res) =>{
                let dCEquipmentContainer = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateDCEquipmentContainer = (e) => {
        e.preventDefault();
        let dCEquipmentContainer = {
                dCEquipmentContainerId: this.state.id,
            };
        console.log('dCEquipmentContainer => ' + JSON.stringify(dCEquipmentContainer));

        // step 5
        if(this.state.id === '_add'){
            dCEquipmentContainer.dCEquipmentContainerId=''
            DCEquipmentContainerService.createDCEquipmentContainer(dCEquipmentContainer).then(res =>{
                this.props.history.push('/dCEquipmentContainers');
            });
        }else{
            DCEquipmentContainerService.updateDCEquipmentContainer(dCEquipmentContainer).then( res => {
                this.props.history.push('/dCEquipmentContainers');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/dCEquipmentContainers');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add DCEquipmentContainer</h3>
        }else{
            return <h3 className="text-center">Update DCEquipmentContainer</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateDCEquipmentContainer}>Save</button>
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

export default CreateDCEquipmentContainerComponent
