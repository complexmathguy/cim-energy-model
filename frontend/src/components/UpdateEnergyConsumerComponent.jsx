import React, { Component } from 'react'
import EnergyConsumerService from '../services/EnergyConsumerService';

class UpdateEnergyConsumerComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                pfixed: '',
                pfixedPct: '',
                qfixed: '',
                qfixedPct: ''
        }
        this.updateEnergyConsumer = this.updateEnergyConsumer.bind(this);

        this.changepfixedHandler = this.changepfixedHandler.bind(this);
        this.changepfixedPctHandler = this.changepfixedPctHandler.bind(this);
        this.changeqfixedHandler = this.changeqfixedHandler.bind(this);
        this.changeqfixedPctHandler = this.changeqfixedPctHandler.bind(this);
    }

    componentDidMount(){
        EnergyConsumerService.getEnergyConsumerById(this.state.id).then( (res) =>{
            let energyConsumer = res.data;
            this.setState({
                pfixed: energyConsumer.pfixed,
                pfixedPct: energyConsumer.pfixedPct,
                qfixed: energyConsumer.qfixed,
                qfixedPct: energyConsumer.qfixedPct
            });
        });
    }

    updateEnergyConsumer = (e) => {
        e.preventDefault();
        let energyConsumer = {
            energyConsumerId: this.state.id,
            pfixed: this.state.pfixed,
            pfixedPct: this.state.pfixedPct,
            qfixed: this.state.qfixed,
            qfixedPct: this.state.qfixedPct
        };
        console.log('energyConsumer => ' + JSON.stringify(energyConsumer));
        console.log('id => ' + JSON.stringify(this.state.id));
        EnergyConsumerService.updateEnergyConsumer(energyConsumer).then( res => {
            this.props.history.push('/energyConsumers');
        });
    }

    changepfixedHandler= (event) => {
        this.setState({pfixed: event.target.value});
    }
    changepfixedPctHandler= (event) => {
        this.setState({pfixedPct: event.target.value});
    }
    changeqfixedHandler= (event) => {
        this.setState({qfixed: event.target.value});
    }
    changeqfixedPctHandler= (event) => {
        this.setState({qfixedPct: event.target.value});
    }

    cancel(){
        this.props.history.push('/energyConsumers');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update EnergyConsumer</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> pfixed: </label>
                                            #formFields( $attribute, 'update')
                                            <label> pfixedPct: </label>
                                            #formFields( $attribute, 'update')
                                            <label> qfixed: </label>
                                            #formFields( $attribute, 'update')
                                            <label> qfixedPct: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateEnergyConsumer}>Save</button>
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

export default UpdateEnergyConsumerComponent
