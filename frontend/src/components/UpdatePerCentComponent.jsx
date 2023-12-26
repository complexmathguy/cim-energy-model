import React, { Component } from 'react'
import PerCentService from '../services/PerCentService';

class UpdatePerCentComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                multiplier: '',
                unit: '',
                value: ''
        }
        this.updatePerCent = this.updatePerCent.bind(this);

        this.changemultiplierHandler = this.changemultiplierHandler.bind(this);
        this.changeunitHandler = this.changeunitHandler.bind(this);
        this.changevalueHandler = this.changevalueHandler.bind(this);
    }

    componentDidMount(){
        PerCentService.getPerCentById(this.state.id).then( (res) =>{
            let perCent = res.data;
            this.setState({
                multiplier: perCent.multiplier,
                unit: perCent.unit,
                value: perCent.value
            });
        });
    }

    updatePerCent = (e) => {
        e.preventDefault();
        let perCent = {
            perCentId: this.state.id,
            multiplier: this.state.multiplier,
            unit: this.state.unit,
            value: this.state.value
        };
        console.log('perCent => ' + JSON.stringify(perCent));
        console.log('id => ' + JSON.stringify(this.state.id));
        PerCentService.updatePerCent(perCent).then( res => {
            this.props.history.push('/perCents');
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
        this.props.history.push('/perCents');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update PerCent</h3>
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
                                        <button className="btn btn-success" onClick={this.updatePerCent}>Save</button>
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

export default UpdatePerCentComponent
