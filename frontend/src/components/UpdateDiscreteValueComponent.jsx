import React, { Component } from 'react'
import DiscreteValueService from '../services/DiscreteValueService';

class UpdateDiscreteValueComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                value: ''
        }
        this.updateDiscreteValue = this.updateDiscreteValue.bind(this);

        this.changevalueHandler = this.changevalueHandler.bind(this);
    }

    componentDidMount(){
        DiscreteValueService.getDiscreteValueById(this.state.id).then( (res) =>{
            let discreteValue = res.data;
            this.setState({
                value: discreteValue.value
            });
        });
    }

    updateDiscreteValue = (e) => {
        e.preventDefault();
        let discreteValue = {
            discreteValueId: this.state.id,
            value: this.state.value
        };
        console.log('discreteValue => ' + JSON.stringify(discreteValue));
        console.log('id => ' + JSON.stringify(this.state.id));
        DiscreteValueService.updateDiscreteValue(discreteValue).then( res => {
            this.props.history.push('/discreteValues');
        });
    }

    changevalueHandler= (event) => {
        this.setState({value: event.target.value});
    }

    cancel(){
        this.props.history.push('/discreteValues');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update DiscreteValue</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> value: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateDiscreteValue}>Save</button>
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

export default UpdateDiscreteValueComponent
