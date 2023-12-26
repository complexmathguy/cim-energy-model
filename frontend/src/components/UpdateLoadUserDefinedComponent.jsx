import React, { Component } from 'react'
import LoadUserDefinedService from '../services/LoadUserDefinedService';

class UpdateLoadUserDefinedComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                proprietary: ''
        }
        this.updateLoadUserDefined = this.updateLoadUserDefined.bind(this);

        this.changeproprietaryHandler = this.changeproprietaryHandler.bind(this);
    }

    componentDidMount(){
        LoadUserDefinedService.getLoadUserDefinedById(this.state.id).then( (res) =>{
            let loadUserDefined = res.data;
            this.setState({
                proprietary: loadUserDefined.proprietary
            });
        });
    }

    updateLoadUserDefined = (e) => {
        e.preventDefault();
        let loadUserDefined = {
            loadUserDefinedId: this.state.id,
            proprietary: this.state.proprietary
        };
        console.log('loadUserDefined => ' + JSON.stringify(loadUserDefined));
        console.log('id => ' + JSON.stringify(this.state.id));
        LoadUserDefinedService.updateLoadUserDefined(loadUserDefined).then( res => {
            this.props.history.push('/loadUserDefineds');
        });
    }

    changeproprietaryHandler= (event) => {
        this.setState({proprietary: event.target.value});
    }

    cancel(){
        this.props.history.push('/loadUserDefineds');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update LoadUserDefined</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> proprietary: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateLoadUserDefined}>Save</button>
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

export default UpdateLoadUserDefinedComponent
