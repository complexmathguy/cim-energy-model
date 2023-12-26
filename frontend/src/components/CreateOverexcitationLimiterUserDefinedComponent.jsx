import React, { Component } from 'react'
import OverexcitationLimiterUserDefinedService from '../services/OverexcitationLimiterUserDefinedService';

class CreateOverexcitationLimiterUserDefinedComponent extends Component {
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
            OverexcitationLimiterUserDefinedService.getOverexcitationLimiterUserDefinedById(this.state.id).then( (res) =>{
                let overexcitationLimiterUserDefined = res.data;
                this.setState({
                    proprietary: overexcitationLimiterUserDefined.proprietary
                });
            });
        }        
    }
    saveOrUpdateOverexcitationLimiterUserDefined = (e) => {
        e.preventDefault();
        let overexcitationLimiterUserDefined = {
                overexcitationLimiterUserDefinedId: this.state.id,
                proprietary: this.state.proprietary
            };
        console.log('overexcitationLimiterUserDefined => ' + JSON.stringify(overexcitationLimiterUserDefined));

        // step 5
        if(this.state.id === '_add'){
            overexcitationLimiterUserDefined.overexcitationLimiterUserDefinedId=''
            OverexcitationLimiterUserDefinedService.createOverexcitationLimiterUserDefined(overexcitationLimiterUserDefined).then(res =>{
                this.props.history.push('/overexcitationLimiterUserDefineds');
            });
        }else{
            OverexcitationLimiterUserDefinedService.updateOverexcitationLimiterUserDefined(overexcitationLimiterUserDefined).then( res => {
                this.props.history.push('/overexcitationLimiterUserDefineds');
            });
        }
    }
    
    changeproprietaryHandler= (event) => {
        this.setState({proprietary: event.target.value});
    }

    cancel(){
        this.props.history.push('/overexcitationLimiterUserDefineds');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add OverexcitationLimiterUserDefined</h3>
        }else{
            return <h3 className="text-center">Update OverexcitationLimiterUserDefined</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateOverexcitationLimiterUserDefined}>Save</button>
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

export default CreateOverexcitationLimiterUserDefinedComponent
