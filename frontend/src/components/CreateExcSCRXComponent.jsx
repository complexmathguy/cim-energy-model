import React, { Component } from 'react'
import ExcSCRXService from '../services/ExcSCRXService';

class CreateExcSCRXComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
                cswitch: '',
                emax: '',
                emin: '',
                k: '',
                rcrfd: '',
                tatb: '',
                tb: '',
                te: ''
        }
        this.changecswitchHandler = this.changecswitchHandler.bind(this);
        this.changeemaxHandler = this.changeemaxHandler.bind(this);
        this.changeeminHandler = this.changeeminHandler.bind(this);
        this.changekHandler = this.changekHandler.bind(this);
        this.changercrfdHandler = this.changercrfdHandler.bind(this);
        this.changetatbHandler = this.changetatbHandler.bind(this);
        this.changetbHandler = this.changetbHandler.bind(this);
        this.changeteHandler = this.changeteHandler.bind(this);
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            ExcSCRXService.getExcSCRXById(this.state.id).then( (res) =>{
                let excSCRX = res.data;
                this.setState({
                    cswitch: excSCRX.cswitch,
                    emax: excSCRX.emax,
                    emin: excSCRX.emin,
                    k: excSCRX.k,
                    rcrfd: excSCRX.rcrfd,
                    tatb: excSCRX.tatb,
                    tb: excSCRX.tb,
                    te: excSCRX.te
                });
            });
        }        
    }
    saveOrUpdateExcSCRX = (e) => {
        e.preventDefault();
        let excSCRX = {
                excSCRXId: this.state.id,
                cswitch: this.state.cswitch,
                emax: this.state.emax,
                emin: this.state.emin,
                k: this.state.k,
                rcrfd: this.state.rcrfd,
                tatb: this.state.tatb,
                tb: this.state.tb,
                te: this.state.te
            };
        console.log('excSCRX => ' + JSON.stringify(excSCRX));

        // step 5
        if(this.state.id === '_add'){
            excSCRX.excSCRXId=''
            ExcSCRXService.createExcSCRX(excSCRX).then(res =>{
                this.props.history.push('/excSCRXs');
            });
        }else{
            ExcSCRXService.updateExcSCRX(excSCRX).then( res => {
                this.props.history.push('/excSCRXs');
            });
        }
    }
    
    changecswitchHandler= (event) => {
        this.setState({cswitch: event.target.value});
    }
    changeemaxHandler= (event) => {
        this.setState({emax: event.target.value});
    }
    changeeminHandler= (event) => {
        this.setState({emin: event.target.value});
    }
    changekHandler= (event) => {
        this.setState({k: event.target.value});
    }
    changercrfdHandler= (event) => {
        this.setState({rcrfd: event.target.value});
    }
    changetatbHandler= (event) => {
        this.setState({tatb: event.target.value});
    }
    changetbHandler= (event) => {
        this.setState({tb: event.target.value});
    }
    changeteHandler= (event) => {
        this.setState({te: event.target.value});
    }

    cancel(){
        this.props.history.push('/excSCRXs');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add ExcSCRX</h3>
        }else{
            return <h3 className="text-center">Update ExcSCRX</h3>
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
                                            <label> cswitch: </label>
                                            #formFields( $attribute, 'create')
                                            <label> emax: </label>
                                            #formFields( $attribute, 'create')
                                            <label> emin: </label>
                                            #formFields( $attribute, 'create')
                                            <label> k: </label>
                                            #formFields( $attribute, 'create')
                                            <label> rcrfd: </label>
                                            #formFields( $attribute, 'create')
                                            <label> tatb: </label>
                                            #formFields( $attribute, 'create')
                                            <label> tb: </label>
                                            #formFields( $attribute, 'create')
                                            <label> te: </label>
                                            #formFields( $attribute, 'create')
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateExcSCRX}>Save</button>
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

export default CreateExcSCRXComponent
