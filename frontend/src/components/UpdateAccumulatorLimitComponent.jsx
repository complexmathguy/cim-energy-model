import React, { Component } from 'react'
import AccumulatorLimitService from '../services/AccumulatorLimitService';

class UpdateAccumulatorLimitComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                value: ''
        }
        this.updateAccumulatorLimit = this.updateAccumulatorLimit.bind(this);

        this.changevalueHandler = this.changevalueHandler.bind(this);
    }

    componentDidMount(){
        AccumulatorLimitService.getAccumulatorLimitById(this.state.id).then( (res) =>{
            let accumulatorLimit = res.data;
            this.setState({
                value: accumulatorLimit.value
            });
        });
    }

    updateAccumulatorLimit = (e) => {
        e.preventDefault();
        let accumulatorLimit = {
            accumulatorLimitId: this.state.id,
            value: this.state.value
        };
        console.log('accumulatorLimit => ' + JSON.stringify(accumulatorLimit));
        console.log('id => ' + JSON.stringify(this.state.id));
        AccumulatorLimitService.updateAccumulatorLimit(accumulatorLimit).then( res => {
            this.props.history.push('/accumulatorLimits');
        });
    }

    changevalueHandler= (event) => {
        this.setState({value: event.target.value});
    }

    cancel(){
        this.props.history.push('/accumulatorLimits');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update AccumulatorLimit</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> value: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateAccumulatorLimit}>Save</button>
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

export default UpdateAccumulatorLimitComponent
