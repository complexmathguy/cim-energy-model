import React, { Component } from 'react'
import WindContCurrLimIECService from '../services/WindContCurrLimIECService';

class CreateWindContCurrLimIECComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
                imax: '',
                imaxdip: '',
                mdfslim: '',
                mqpri: '',
                tufilt: ''
        }
        this.changeimaxHandler = this.changeimaxHandler.bind(this);
        this.changeimaxdipHandler = this.changeimaxdipHandler.bind(this);
        this.changemdfslimHandler = this.changemdfslimHandler.bind(this);
        this.changemqpriHandler = this.changemqpriHandler.bind(this);
        this.changetufiltHandler = this.changetufiltHandler.bind(this);
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
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
    }
    saveOrUpdateWindContCurrLimIEC = (e) => {
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

        // step 5
        if(this.state.id === '_add'){
            windContCurrLimIEC.windContCurrLimIECId=''
            WindContCurrLimIECService.createWindContCurrLimIEC(windContCurrLimIEC).then(res =>{
                this.props.history.push('/windContCurrLimIECs');
            });
        }else{
            WindContCurrLimIECService.updateWindContCurrLimIEC(windContCurrLimIEC).then( res => {
                this.props.history.push('/windContCurrLimIECs');
            });
        }
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

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add WindContCurrLimIEC</h3>
        }else{
            return <h3 className="text-center">Update WindContCurrLimIEC</h3>
        }
    }
    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                {
                                    this.getTitle()
                                }
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> imax: </label>
                                            #formFields( $attribute, 'create')
                                            <label> imaxdip: </label>
                                            #formFields( $attribute, 'create')
                                            <label> mdfslim: </label>
                                            #formFields( $attribute, 'create')
                                            <label> mqpri: </label>
                                            #formFields( $attribute, 'create')
                                            <label> tufilt: </label>
                                            #formFields( $attribute, 'create')
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateWindContCurrLimIEC}>Save</button>
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

export default CreateWindContCurrLimIECComponent
