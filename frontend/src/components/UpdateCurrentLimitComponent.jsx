import React, { Component } from 'react'
import CurrentLimitService from '../services/CurrentLimitService';

class UpdateCurrentLimitComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                value: ''
        }
        this.updateCurrentLimit = this.updateCurrentLimit.bind(this);

        this.changevalueHandler = this.changevalueHandler.bind(this);
    }

    componentDidMount(){
        CurrentLimitService.getCurrentLimitById(this.state.id).then( (res) =>{
            let currentLimit = res.data;
            this.setState({
                value: currentLimit.value
            });
        });
    }

    updateCurrentLimit = (e) => {
        e.preventDefault();
        let currentLimit = {
            currentLimitId: this.state.id,
            value: this.state.value
        };
        console.log('currentLimit => ' + JSON.stringify(currentLimit));
        console.log('id => ' + JSON.stringify(this.state.id));
        CurrentLimitService.updateCurrentLimit(currentLimit).then( res => {
            this.props.history.push('/currentLimits');
        });
    }

    changevalueHandler= (event) => {
        this.setState({value: event.target.value});
    }

    cancel(){
        this.props.history.push('/currentLimits');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update CurrentLimit</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> value: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateCurrentLimit}>Save</button>
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

export default UpdateCurrentLimitComponent
