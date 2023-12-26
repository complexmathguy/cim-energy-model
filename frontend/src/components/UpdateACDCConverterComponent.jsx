import React, { Component } from 'react'
import ACDCConverterService from '../services/ACDCConverterService';

class UpdateACDCConverterComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                baseS: '',
                idleLoss: '',
                maxUdc: '',
                minUdc: '',
                numberOfValves: '',
                ratedUdc: '',
                resistiveLoss: '',
                switchingLoss: '',
                valveU0: ''
        }
        this.updateACDCConverter = this.updateACDCConverter.bind(this);

        this.changebaseSHandler = this.changebaseSHandler.bind(this);
        this.changeidleLossHandler = this.changeidleLossHandler.bind(this);
        this.changemaxUdcHandler = this.changemaxUdcHandler.bind(this);
        this.changeminUdcHandler = this.changeminUdcHandler.bind(this);
        this.changenumberOfValvesHandler = this.changenumberOfValvesHandler.bind(this);
        this.changeratedUdcHandler = this.changeratedUdcHandler.bind(this);
        this.changeresistiveLossHandler = this.changeresistiveLossHandler.bind(this);
        this.changeswitchingLossHandler = this.changeswitchingLossHandler.bind(this);
        this.changevalveU0Handler = this.changevalveU0Handler.bind(this);
    }

    componentDidMount(){
        ACDCConverterService.getACDCConverterById(this.state.id).then( (res) =>{
            let aCDCConverter = res.data;
            this.setState({
                baseS: aCDCConverter.baseS,
                idleLoss: aCDCConverter.idleLoss,
                maxUdc: aCDCConverter.maxUdc,
                minUdc: aCDCConverter.minUdc,
                numberOfValves: aCDCConverter.numberOfValves,
                ratedUdc: aCDCConverter.ratedUdc,
                resistiveLoss: aCDCConverter.resistiveLoss,
                switchingLoss: aCDCConverter.switchingLoss,
                valveU0: aCDCConverter.valveU0
            });
        });
    }

    updateACDCConverter = (e) => {
        e.preventDefault();
        let aCDCConverter = {
            aCDCConverterId: this.state.id,
            baseS: this.state.baseS,
            idleLoss: this.state.idleLoss,
            maxUdc: this.state.maxUdc,
            minUdc: this.state.minUdc,
            numberOfValves: this.state.numberOfValves,
            ratedUdc: this.state.ratedUdc,
            resistiveLoss: this.state.resistiveLoss,
            switchingLoss: this.state.switchingLoss,
            valveU0: this.state.valveU0
        };
        console.log('aCDCConverter => ' + JSON.stringify(aCDCConverter));
        console.log('id => ' + JSON.stringify(this.state.id));
        ACDCConverterService.updateACDCConverter(aCDCConverter).then( res => {
            this.props.history.push('/aCDCConverters');
        });
    }

    changebaseSHandler= (event) => {
        this.setState({baseS: event.target.value});
    }
    changeidleLossHandler= (event) => {
        this.setState({idleLoss: event.target.value});
    }
    changemaxUdcHandler= (event) => {
        this.setState({maxUdc: event.target.value});
    }
    changeminUdcHandler= (event) => {
        this.setState({minUdc: event.target.value});
    }
    changenumberOfValvesHandler= (event) => {
        this.setState({numberOfValves: event.target.value});
    }
    changeratedUdcHandler= (event) => {
        this.setState({ratedUdc: event.target.value});
    }
    changeresistiveLossHandler= (event) => {
        this.setState({resistiveLoss: event.target.value});
    }
    changeswitchingLossHandler= (event) => {
        this.setState({switchingLoss: event.target.value});
    }
    changevalveU0Handler= (event) => {
        this.setState({valveU0: event.target.value});
    }

    cancel(){
        this.props.history.push('/aCDCConverters');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update ACDCConverter</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> baseS: </label>
                                            #formFields( $attribute, 'update')
                                            <label> idleLoss: </label>
                                            #formFields( $attribute, 'update')
                                            <label> maxUdc: </label>
                                            #formFields( $attribute, 'update')
                                            <label> minUdc: </label>
                                            #formFields( $attribute, 'update')
                                            <label> numberOfValves: </label>
                                            #formFields( $attribute, 'update')
                                            <label> ratedUdc: </label>
                                            #formFields( $attribute, 'update')
                                            <label> resistiveLoss: </label>
                                            #formFields( $attribute, 'update')
                                            <label> switchingLoss: </label>
                                            #formFields( $attribute, 'update')
                                            <label> valveU0: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateACDCConverter}>Save</button>
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

export default UpdateACDCConverterComponent
