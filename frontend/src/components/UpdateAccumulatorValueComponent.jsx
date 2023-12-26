import React, { Component } from 'react'
import AccumulatorValueService from '../services/AccumulatorValueService';

class UpdateAccumulatorValueComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                value: ''
        }
        this.updateAccumulatorValue = this.updateAccumulatorValue.bind(this);

        this.changevalueHandler = this.changevalueHandler.bind(this);
    }

    componentDidMount(){
        AccumulatorValueService.getAccumulatorValueById(this.state.id).then( (res) =>{
            let accumulatorValue = res.data;
            this.setState({
                value: accumulatorValue.value
            });
        });
    }

    updateAccumulatorValue = (e) => {
        e.preventDefault();
        let accumulatorValue = {
            accumulatorValueId: this.state.id,
            value: this.state.value
        };
        console.log('accumulatorValue => ' + JSON.stringify(accumulatorValue));
        console.log('id => ' + JSON.stringify(this.state.id));
        AccumulatorValueService.updateAccumulatorValue(accumulatorValue).then( res => {
            this.props.history.push('/accumulatorValues');
        });
    }

    changevalueHandler= (event) => {
        this.setState({value: event.target.value});
    }

    cancel(){
        this.props.history.push('/accumulatorValues');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update AccumulatorValue</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> value: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateAccumulatorValue}>Save</button>
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

export default UpdateAccumulatorValueComponent
