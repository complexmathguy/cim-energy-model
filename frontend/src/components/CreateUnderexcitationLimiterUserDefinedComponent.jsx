import React, { Component } from 'react'
import UnderexcitationLimiterUserDefinedService from '../services/UnderexcitationLimiterUserDefinedService';

class CreateUnderexcitationLimiterUserDefinedComponent extends Component {
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
            UnderexcitationLimiterUserDefinedService.getUnderexcitationLimiterUserDefinedById(this.state.id).then( (res) =>{
                let underexcitationLimiterUserDefined = res.data;
                this.setState({
                    proprietary: underexcitationLimiterUserDefined.proprietary
                });
            });
        }        
    }
    saveOrUpdateUnderexcitationLimiterUserDefined = (e) => {
        e.preventDefault();
        let underexcitationLimiterUserDefined = {
                underexcitationLimiterUserDefinedId: this.state.id,
                proprietary: this.state.proprietary
            };
        console.log('underexcitationLimiterUserDefined => ' + JSON.stringify(underexcitationLimiterUserDefined));

        // step 5
        if(this.state.id === '_add'){
            underexcitationLimiterUserDefined.underexcitationLimiterUserDefinedId=''
            UnderexcitationLimiterUserDefinedService.createUnderexcitationLimiterUserDefined(underexcitationLimiterUserDefined).then(res =>{
                this.props.history.push('/underexcitationLimiterUserDefineds');
            });
        }else{
            UnderexcitationLimiterUserDefinedService.updateUnderexcitationLimiterUserDefined(underexcitationLimiterUserDefined).then( res => {
                this.props.history.push('/underexcitationLimiterUserDefineds');
            });
        }
    }
    
    changeproprietaryHandler= (event) => {
        this.setState({proprietary: event.target.value});
    }

    cancel(){
        this.props.history.push('/underexcitationLimiterUserDefineds');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add UnderexcitationLimiterUserDefined</h3>
        }else{
            return <h3 className="text-center">Update UnderexcitationLimiterUserDefined</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateUnderexcitationLimiterUserDefined}>Save</button>
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

export default CreateUnderexcitationLimiterUserDefinedComponent
