import React, { Component } from 'react'
import DCEquipmentContainerService from '../services/DCEquipmentContainerService';

class UpdateDCEquipmentContainerComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateDCEquipmentContainer = this.updateDCEquipmentContainer.bind(this);

    }

    componentDidMount(){
        DCEquipmentContainerService.getDCEquipmentContainerById(this.state.id).then( (res) =>{
            let dCEquipmentContainer = res.data;
            this.setState({
            });
        });
    }

    updateDCEquipmentContainer = (e) => {
        e.preventDefault();
        let dCEquipmentContainer = {
            dCEquipmentContainerId: this.state.id,
        };
        console.log('dCEquipmentContainer => ' + JSON.stringify(dCEquipmentContainer));
        console.log('id => ' + JSON.stringify(this.state.id));
        DCEquipmentContainerService.updateDCEquipmentContainer(dCEquipmentContainer).then( res => {
            this.props.history.push('/dCEquipmentContainers');
        });
    }


    cancel(){
        this.props.history.push('/dCEquipmentContainers');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update DCEquipmentContainer</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateDCEquipmentContainer}>Save</button>
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

export default UpdateDCEquipmentContainerComponent
