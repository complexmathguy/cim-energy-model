import React, { Component } from 'react'
import WindAeroLinearIECService from '../services/WindAeroLinearIECService';

class CreateWindAeroLinearIECComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
                dpomega: '',
                dptheta: '',
                omegazero: '',
                pavail: '',
                thetazero: ''
        }
        this.changedpomegaHandler = this.changedpomegaHandler.bind(this);
        this.changedpthetaHandler = this.changedpthetaHandler.bind(this);
        this.changeomegazeroHandler = this.changeomegazeroHandler.bind(this);
        this.changepavailHandler = this.changepavailHandler.bind(this);
        this.changethetazeroHandler = this.changethetazeroHandler.bind(this);
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            WindAeroLinearIECService.getWindAeroLinearIECById(this.state.id).then( (res) =>{
                let windAeroLinearIEC = res.data;
                this.setState({
                    dpomega: windAeroLinearIEC.dpomega,
                    dptheta: windAeroLinearIEC.dptheta,
                    omegazero: windAeroLinearIEC.omegazero,
                    pavail: windAeroLinearIEC.pavail,
                    thetazero: windAeroLinearIEC.thetazero
                });
            });
        }        
    }
    saveOrUpdateWindAeroLinearIEC = (e) => {
        e.preventDefault();
        let windAeroLinearIEC = {
                windAeroLinearIECId: this.state.id,
                dpomega: this.state.dpomega,
                dptheta: this.state.dptheta,
                omegazero: this.state.omegazero,
                pavail: this.state.pavail,
                thetazero: this.state.thetazero
            };
        console.log('windAeroLinearIEC => ' + JSON.stringify(windAeroLinearIEC));

        // step 5
        if(this.state.id === '_add'){
            windAeroLinearIEC.windAeroLinearIECId=''
            WindAeroLinearIECService.createWindAeroLinearIEC(windAeroLinearIEC).then(res =>{
                this.props.history.push('/windAeroLinearIECs');
            });
        }else{
            WindAeroLinearIECService.updateWindAeroLinearIEC(windAeroLinearIEC).then( res => {
                this.props.history.push('/windAeroLinearIECs');
            });
        }
    }
    
    changedpomegaHandler= (event) => {
        this.setState({dpomega: event.target.value});
    }
    changedpthetaHandler= (event) => {
        this.setState({dptheta: event.target.value});
    }
    changeomegazeroHandler= (event) => {
        this.setState({omegazero: event.target.value});
    }
    changepavailHandler= (event) => {
        this.setState({pavail: event.target.value});
    }
    changethetazeroHandler= (event) => {
        this.setState({thetazero: event.target.value});
    }

    cancel(){
        this.props.history.push('/windAeroLinearIECs');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add WindAeroLinearIEC</h3>
        }else{
            return <h3 className="text-center">Update WindAeroLinearIEC</h3>
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
                                            <label> dpomega: </label>
                                            #formFields( $attribute, 'create')
                                            <label> dptheta: </label>
                                            #formFields( $attribute, 'create')
                                            <label> omegazero: </label>
                                            #formFields( $attribute, 'create')
                                            <label> pavail: </label>
                                            #formFields( $attribute, 'create')
                                            <label> thetazero: </label>
                                            #formFields( $attribute, 'create')
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateWindAeroLinearIEC}>Save</button>
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

export default CreateWindAeroLinearIECComponent
