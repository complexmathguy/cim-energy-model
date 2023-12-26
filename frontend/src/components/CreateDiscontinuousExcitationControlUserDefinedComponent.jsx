import React, { Component } from 'react'
import DiscontinuousExcitationControlUserDefinedService from '../services/DiscontinuousExcitationControlUserDefinedService';

class CreateDiscontinuousExcitationControlUserDefinedComponent extends Component {
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
            DiscontinuousExcitationControlUserDefinedService.getDiscontinuousExcitationControlUserDefinedById(this.state.id).then( (res) =>{
                let discontinuousExcitationControlUserDefined = res.data;
                this.setState({
                    proprietary: discontinuousExcitationControlUserDefined.proprietary
                });
            });
        }        
    }
    saveOrUpdateDiscontinuousExcitationControlUserDefined = (e) => {
        e.preventDefault();
        let discontinuousExcitationControlUserDefined = {
                discontinuousExcitationControlUserDefinedId: this.state.id,
                proprietary: this.state.proprietary
            };
        console.log('discontinuousExcitationControlUserDefined => ' + JSON.stringify(discontinuousExcitationControlUserDefined));

        // step 5
        if(this.state.id === '_add'){
            discontinuousExcitationControlUserDefined.discontinuousExcitationControlUserDefinedId=''
            DiscontinuousExcitationControlUserDefinedService.createDiscontinuousExcitationControlUserDefined(discontinuousExcitationControlUserDefined).then(res =>{
                this.props.history.push('/discontinuousExcitationControlUserDefineds');
            });
        }else{
            DiscontinuousExcitationControlUserDefinedService.updateDiscontinuousExcitationControlUserDefined(discontinuousExcitationControlUserDefined).then( res => {
                this.props.history.push('/discontinuousExcitationControlUserDefineds');
            });
        }
    }
    
    changeproprietaryHandler= (event) => {
        this.setState({proprietary: event.target.value});
    }

    cancel(){
        this.props.history.push('/discontinuousExcitationControlUserDefineds');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add DiscontinuousExcitationControlUserDefined</h3>
        }else{
            return <h3 className="text-center">Update DiscontinuousExcitationControlUserDefined</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateDiscontinuousExcitationControlUserDefined}>Save</button>
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

export default CreateDiscontinuousExcitationControlUserDefinedComponent
