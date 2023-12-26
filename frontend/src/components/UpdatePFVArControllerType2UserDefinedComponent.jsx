import React, { Component } from 'react'
import PFVArControllerType2UserDefinedService from '../services/PFVArControllerType2UserDefinedService';

class UpdatePFVArControllerType2UserDefinedComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                proprietary: ''
        }
        this.updatePFVArControllerType2UserDefined = this.updatePFVArControllerType2UserDefined.bind(this);

        this.changeproprietaryHandler = this.changeproprietaryHandler.bind(this);
    }

    componentDidMount(){
        PFVArControllerType2UserDefinedService.getPFVArControllerType2UserDefinedById(this.state.id).then( (res) =>{
            let pFVArControllerType2UserDefined = res.data;
            this.setState({
                proprietary: pFVArControllerType2UserDefined.proprietary
            });
        });
    }

    updatePFVArControllerType2UserDefined = (e) => {
        e.preventDefault();
        let pFVArControllerType2UserDefined = {
            pFVArControllerType2UserDefinedId: this.state.id,
            proprietary: this.state.proprietary
        };
        console.log('pFVArControllerType2UserDefined => ' + JSON.stringify(pFVArControllerType2UserDefined));
        console.log('id => ' + JSON.stringify(this.state.id));
        PFVArControllerType2UserDefinedService.updatePFVArControllerType2UserDefined(pFVArControllerType2UserDefined).then( res => {
            this.props.history.push('/pFVArControllerType2UserDefineds');
        });
    }

    changeproprietaryHandler= (event) => {
        this.setState({proprietary: event.target.value});
    }

    cancel(){
        this.props.history.push('/pFVArControllerType2UserDefineds');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update PFVArControllerType2UserDefined</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> proprietary: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updatePFVArControllerType2UserDefined}>Save</button>
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

export default UpdatePFVArControllerType2UserDefinedComponent
