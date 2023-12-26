import React, { Component } from 'react'
import AsynchronousMachineDynamicsService from '../services/AsynchronousMachineDynamicsService';

class CreateAsynchronousMachineDynamicsComponent extends Component {
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
            AsynchronousMachineDynamicsService.getAsynchronousMachineDynamicsById(this.state.id).then( (res) =>{
                let asynchronousMachineDynamics = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateAsynchronousMachineDynamics = (e) => {
        e.preventDefault();
        let asynchronousMachineDynamics = {
                asynchronousMachineDynamicsId: this.state.id,
            };
        console.log('asynchronousMachineDynamics => ' + JSON.stringify(asynchronousMachineDynamics));

        // step 5
        if(this.state.id === '_add'){
            asynchronousMachineDynamics.asynchronousMachineDynamicsId=''
            AsynchronousMachineDynamicsService.createAsynchronousMachineDynamics(asynchronousMachineDynamics).then(res =>{
                this.props.history.push('/asynchronousMachineDynamicss');
            });
        }else{
            AsynchronousMachineDynamicsService.updateAsynchronousMachineDynamics(asynchronousMachineDynamics).then( res => {
                this.props.history.push('/asynchronousMachineDynamicss');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/asynchronousMachineDynamicss');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add AsynchronousMachineDynamics</h3>
        }else{
            return <h3 className="text-center">Update AsynchronousMachineDynamics</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateAsynchronousMachineDynamics}>Save</button>
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

export default CreateAsynchronousMachineDynamicsComponent
