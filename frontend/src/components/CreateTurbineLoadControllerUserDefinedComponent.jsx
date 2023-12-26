import React, { Component } from 'react'
import TurbineLoadControllerUserDefinedService from '../services/TurbineLoadControllerUserDefinedService';

class CreateTurbineLoadControllerUserDefinedComponent extends Component {
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
            TurbineLoadControllerUserDefinedService.getTurbineLoadControllerUserDefinedById(this.state.id).then( (res) =>{
                let turbineLoadControllerUserDefined = res.data;
                this.setState({
                    proprietary: turbineLoadControllerUserDefined.proprietary
                });
            });
        }        
    }
    saveOrUpdateTurbineLoadControllerUserDefined = (e) => {
        e.preventDefault();
        let turbineLoadControllerUserDefined = {
                turbineLoadControllerUserDefinedId: this.state.id,
                proprietary: this.state.proprietary
            };
        console.log('turbineLoadControllerUserDefined => ' + JSON.stringify(turbineLoadControllerUserDefined));

        // step 5
        if(this.state.id === '_add'){
            turbineLoadControllerUserDefined.turbineLoadControllerUserDefinedId=''
            TurbineLoadControllerUserDefinedService.createTurbineLoadControllerUserDefined(turbineLoadControllerUserDefined).then(res =>{
                this.props.history.push('/turbineLoadControllerUserDefineds');
            });
        }else{
            TurbineLoadControllerUserDefinedService.updateTurbineLoadControllerUserDefined(turbineLoadControllerUserDefined).then( res => {
                this.props.history.push('/turbineLoadControllerUserDefineds');
            });
        }
    }
    
    changeproprietaryHandler= (event) => {
        this.setState({proprietary: event.target.value});
    }

    cancel(){
        this.props.history.push('/turbineLoadControllerUserDefineds');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add TurbineLoadControllerUserDefined</h3>
        }else{
            return <h3 className="text-center">Update TurbineLoadControllerUserDefined</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateTurbineLoadControllerUserDefined}>Save</button>
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

export default CreateTurbineLoadControllerUserDefinedComponent
