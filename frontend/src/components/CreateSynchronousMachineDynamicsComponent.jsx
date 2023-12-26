import React, { Component } from 'react'
import SynchronousMachineDynamicsService from '../services/SynchronousMachineDynamicsService';

class CreateSynchronousMachineDynamicsComponent extends Component {
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
            SynchronousMachineDynamicsService.getSynchronousMachineDynamicsById(this.state.id).then( (res) =>{
                let synchronousMachineDynamics = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateSynchronousMachineDynamics = (e) => {
        e.preventDefault();
        let synchronousMachineDynamics = {
                synchronousMachineDynamicsId: this.state.id,
            };
        console.log('synchronousMachineDynamics => ' + JSON.stringify(synchronousMachineDynamics));

        // step 5
        if(this.state.id === '_add'){
            synchronousMachineDynamics.synchronousMachineDynamicsId=''
            SynchronousMachineDynamicsService.createSynchronousMachineDynamics(synchronousMachineDynamics).then(res =>{
                this.props.history.push('/synchronousMachineDynamicss');
            });
        }else{
            SynchronousMachineDynamicsService.updateSynchronousMachineDynamics(synchronousMachineDynamics).then( res => {
                this.props.history.push('/synchronousMachineDynamicss');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/synchronousMachineDynamicss');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add SynchronousMachineDynamics</h3>
        }else{
            return <h3 className="text-center">Update SynchronousMachineDynamics</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateSynchronousMachineDynamics}>Save</button>
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

export default CreateSynchronousMachineDynamicsComponent
