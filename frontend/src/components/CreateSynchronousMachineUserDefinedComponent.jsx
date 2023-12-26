import React, { Component } from 'react'
import SynchronousMachineUserDefinedService from '../services/SynchronousMachineUserDefinedService';

class CreateSynchronousMachineUserDefinedComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
                proprietary: ''
        }
        this.changeproprietaryHandler = this.changeproprietaryHandler.bind(this);
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            SynchronousMachineUserDefinedService.getSynchronousMachineUserDefinedById(this.state.id).then( (res) =>{
                let synchronousMachineUserDefined = res.data;
                this.setState({
                    proprietary: synchronousMachineUserDefined.proprietary
                });
            });
        }        
    }
    saveOrUpdateSynchronousMachineUserDefined = (e) => {
        e.preventDefault();
        let synchronousMachineUserDefined = {
                synchronousMachineUserDefinedId: this.state.id,
                proprietary: this.state.proprietary
            };
        console.log('synchronousMachineUserDefined => ' + JSON.stringify(synchronousMachineUserDefined));

        // step 5
        if(this.state.id === '_add'){
            synchronousMachineUserDefined.synchronousMachineUserDefinedId=''
            SynchronousMachineUserDefinedService.createSynchronousMachineUserDefined(synchronousMachineUserDefined).then(res =>{
                this.props.history.push('/synchronousMachineUserDefineds');
            });
        }else{
            SynchronousMachineUserDefinedService.updateSynchronousMachineUserDefined(synchronousMachineUserDefined).then( res => {
                this.props.history.push('/synchronousMachineUserDefineds');
            });
        }
    }
    
    changeproprietaryHandler= (event) => {
        this.setState({proprietary: event.target.value});
    }

    cancel(){
        this.props.history.push('/synchronousMachineUserDefineds');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add SynchronousMachineUserDefined</h3>
        }else{
            return <h3 className="text-center">Update SynchronousMachineUserDefined</h3>
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
                                            <label> proprietary: </label>
                                            #formFields( $attribute, 'create')
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateSynchronousMachineUserDefined}>Save</button>
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

export default CreateSynchronousMachineUserDefinedComponent
