import React, { Component } from 'react'
import AsynchronousMachineUserDefinedService from '../services/AsynchronousMachineUserDefinedService';

class CreateAsynchronousMachineUserDefinedComponent extends Component {
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
            AsynchronousMachineUserDefinedService.getAsynchronousMachineUserDefinedById(this.state.id).then( (res) =>{
                let asynchronousMachineUserDefined = res.data;
                this.setState({
                    proprietary: asynchronousMachineUserDefined.proprietary
                });
            });
        }        
    }
    saveOrUpdateAsynchronousMachineUserDefined = (e) => {
        e.preventDefault();
        let asynchronousMachineUserDefined = {
                asynchronousMachineUserDefinedId: this.state.id,
                proprietary: this.state.proprietary
            };
        console.log('asynchronousMachineUserDefined => ' + JSON.stringify(asynchronousMachineUserDefined));

        // step 5
        if(this.state.id === '_add'){
            asynchronousMachineUserDefined.asynchronousMachineUserDefinedId=''
            AsynchronousMachineUserDefinedService.createAsynchronousMachineUserDefined(asynchronousMachineUserDefined).then(res =>{
                this.props.history.push('/asynchronousMachineUserDefineds');
            });
        }else{
            AsynchronousMachineUserDefinedService.updateAsynchronousMachineUserDefined(asynchronousMachineUserDefined).then( res => {
                this.props.history.push('/asynchronousMachineUserDefineds');
            });
        }
    }
    
    changeproprietaryHandler= (event) => {
        this.setState({proprietary: event.target.value});
    }

    cancel(){
        this.props.history.push('/asynchronousMachineUserDefineds');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add AsynchronousMachineUserDefined</h3>
        }else{
            return <h3 className="text-center">Update AsynchronousMachineUserDefined</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateAsynchronousMachineUserDefined}>Save</button>
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

export default CreateAsynchronousMachineUserDefinedComponent
