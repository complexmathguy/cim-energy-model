import React, { Component } from 'react'
import MechanicalLoadUserDefinedService from '../services/MechanicalLoadUserDefinedService';

class CreateMechanicalLoadUserDefinedComponent extends Component {
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
            MechanicalLoadUserDefinedService.getMechanicalLoadUserDefinedById(this.state.id).then( (res) =>{
                let mechanicalLoadUserDefined = res.data;
                this.setState({
                    proprietary: mechanicalLoadUserDefined.proprietary
                });
            });
        }        
    }
    saveOrUpdateMechanicalLoadUserDefined = (e) => {
        e.preventDefault();
        let mechanicalLoadUserDefined = {
                mechanicalLoadUserDefinedId: this.state.id,
                proprietary: this.state.proprietary
            };
        console.log('mechanicalLoadUserDefined => ' + JSON.stringify(mechanicalLoadUserDefined));

        // step 5
        if(this.state.id === '_add'){
            mechanicalLoadUserDefined.mechanicalLoadUserDefinedId=''
            MechanicalLoadUserDefinedService.createMechanicalLoadUserDefined(mechanicalLoadUserDefined).then(res =>{
                this.props.history.push('/mechanicalLoadUserDefineds');
            });
        }else{
            MechanicalLoadUserDefinedService.updateMechanicalLoadUserDefined(mechanicalLoadUserDefined).then( res => {
                this.props.history.push('/mechanicalLoadUserDefineds');
            });
        }
    }
    
    changeproprietaryHandler= (event) => {
        this.setState({proprietary: event.target.value});
    }

    cancel(){
        this.props.history.push('/mechanicalLoadUserDefineds');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add MechanicalLoadUserDefined</h3>
        }else{
            return <h3 className="text-center">Update MechanicalLoadUserDefined</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateMechanicalLoadUserDefined}>Save</button>
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

export default CreateMechanicalLoadUserDefinedComponent
