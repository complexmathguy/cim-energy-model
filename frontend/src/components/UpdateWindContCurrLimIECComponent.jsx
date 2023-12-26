import React, { Component } from 'react'
import WindContCurrLimIECService from '../services/WindContCurrLimIECService';

class UpdateWindContCurrLimIECComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                imax: '',
                imaxdip: '',
                mdfslim: '',
                mqpri: '',
                tufilt: ''
        }
        this.updateWindContCurrLimIEC = this.updateWindContCurrLimIEC.bind(this);

        this.changeimaxHandler = this.changeimaxHandler.bind(this);
        this.changeimaxdipHandler = this.changeimaxdipHandler.bind(this);
        this.changemdfslimHandler = this.changemdfslimHandler.bind(this);
        this.changemqpriHandler = this.changemqpriHandler.bind(this);
        this.changetufiltHandler = this.changetufiltHandler.bind(this);
    }

    componentDidMount(){
        WindContCurrLimIECService.getWindContCurrLimIECById(this.state.id).then( (res) =>{
            let windContCurrLimIEC = res.data;
            this.setState({
                imax: windContCurrLimIEC.imax,
                imaxdip: windContCurrLimIEC.imaxdip,
                mdfslim: windContCurrLimIEC.mdfslim,
                mqpri: windContCurrLimIEC.mqpri,
                tufilt: windContCurrLimIEC.tufilt
            });
        });
    }

    updateWindContCurrLimIEC = (e) => {
        e.preventDefault();
        let windContCurrLimIEC = {
            windContCurrLimIECId: this.state.id,
            imax: this.state.imax,
            imaxdip: this.state.imaxdip,
            mdfslim: this.state.mdfslim,
            mqpri: this.state.mqpri,
            tufilt: this.state.tufilt
        };
        console.log('windContCurrLimIEC => ' + JSON.stringify(windContCurrLimIEC));
        console.log('id => ' + JSON.stringify(this.state.id));
        WindContCurrLimIECService.updateWindContCurrLimIEC(windContCurrLimIEC).then( res => {
            this.props.history.push('/windContCurrLimIECs');
        });
    }

    changeimaxHandler= (event) => {
        this.setState({imax: event.target.value});
    }
    changeimaxdipHandler= (event) => {
        this.setState({imaxdip: event.target.value});
    }
    changemdfslimHandler= (event) => {
        this.setState({mdfslim: event.target.value});
    }
    changemqpriHandler= (event) => {
        this.setState({mqpri: event.target.value});
    }
    changetufiltHandler= (event) => {
        this.setState({tufilt: event.target.value});
    }

    cancel(){
        this.props.history.push('/windContCurrLimIECs');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update WindContCurrLimIEC</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> imax: </label>
                                            #formFields( $attribute, 'update')
                                            <label> imaxdip: </label>
                                            #formFields( $attribute, 'update')
                                            <label> mdfslim: </label>
                                            #formFields( $attribute, 'update')
                                            <label> mqpri: </label>
                                            #formFields( $attribute, 'update')
                                            <label> tufilt: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateWindContCurrLimIEC}>Save</button>
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

export default UpdateWindContCurrLimIECComponent
