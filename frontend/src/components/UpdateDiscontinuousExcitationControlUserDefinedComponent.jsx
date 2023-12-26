import React, { Component } from 'react'
import DiscontinuousExcitationControlUserDefinedService from '../services/DiscontinuousExcitationControlUserDefinedService';

class UpdateDiscontinuousExcitationControlUserDefinedComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                proprietary: ''
        }
        this.updateDiscontinuousExcitationControlUserDefined = this.updateDiscontinuousExcitationControlUserDefined.bind(this);

        this.changeproprietaryHandler = this.changeproprietaryHandler.bind(this);
    }

    componentDidMount(){
        DiscontinuousExcitationControlUserDefinedService.getDiscontinuousExcitationControlUserDefinedById(this.state.id).then( (res) =>{
            let discontinuousExcitationControlUserDefined = res.data;
            this.setState({
                proprietary: discontinuousExcitationControlUserDefined.proprietary
            });
        });
    }

    updateDiscontinuousExcitationControlUserDefined = (e) => {
        e.preventDefault();
        let discontinuousExcitationControlUserDefined = {
            discontinuousExcitationControlUserDefinedId: this.state.id,
            proprietary: this.state.proprietary
        };
        console.log('discontinuousExcitationControlUserDefined => ' + JSON.stringify(discontinuousExcitationControlUserDefined));
        console.log('id => ' + JSON.stringify(this.state.id));
        DiscontinuousExcitationControlUserDefinedService.updateDiscontinuousExcitationControlUserDefined(discontinuousExcitationControlUserDefined).then( res => {
            this.props.history.push('/discontinuousExcitationControlUserDefineds');
        });
    }

    changeproprietaryHandler= (event) => {
        this.setState({proprietary: event.target.value});
    }

    cancel(){
        this.props.history.push('/discontinuousExcitationControlUserDefineds');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update DiscontinuousExcitationControlUserDefined</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> proprietary: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateDiscontinuousExcitationControlUserDefined}>Save</button>
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

export default UpdateDiscontinuousExcitationControlUserDefinedComponent
