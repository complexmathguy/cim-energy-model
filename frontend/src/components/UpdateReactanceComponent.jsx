import React, { Component } from 'react'
import ReactanceService from '../services/ReactanceService';

class UpdateReactanceComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                multiplier: '',
                unit: '',
                value: ''
        }
        this.updateReactance = this.updateReactance.bind(this);

        this.changemultiplierHandler = this.changemultiplierHandler.bind(this);
        this.changeunitHandler = this.changeunitHandler.bind(this);
        this.changevalueHandler = this.changevalueHandler.bind(this);
    }

    componentDidMount(){
        ReactanceService.getReactanceById(this.state.id).then( (res) =>{
            let reactance = res.data;
            this.setState({
                multiplier: reactance.multiplier,
                unit: reactance.unit,
                value: reactance.value
            });
        });
    }

    updateReactance = (e) => {
        e.preventDefault();
        let reactance = {
            reactanceId: this.state.id,
            multiplier: this.state.multiplier,
            unit: this.state.unit,
            value: this.state.value
        };
        console.log('reactance => ' + JSON.stringify(reactance));
        console.log('id => ' + JSON.stringify(this.state.id));
        ReactanceService.updateReactance(reactance).then( res => {
            this.props.history.push('/reactances');
        });
    }

    changemultiplierHandler= (event) => {
        this.setState({multiplier: event.target.value});
    }
    changeunitHandler= (event) => {
        this.setState({unit: event.target.value});
    }
    changevalueHandler= (event) => {
        this.setState({value: event.target.value});
    }

    cancel(){
        this.props.history.push('/reactances');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update Reactance</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> multiplier: </label>
                                            #formFields( $attribute, 'update')
                                            <label> unit: </label>
                                            #formFields( $attribute, 'update')
                                            <label> value: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateReactance}>Save</button>
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

export default UpdateReactanceComponent
