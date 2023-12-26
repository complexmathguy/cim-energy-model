import React, { Component } from 'react'
import WindGenType4IECService from '../services/WindGenType4IECService';

class CreateWindGenType4IECComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
                dipmax: '',
                diqmax: '',
                diqmin: '',
                tg: ''
        }
        this.changedipmaxHandler = this.changedipmaxHandler.bind(this);
        this.changediqmaxHandler = this.changediqmaxHandler.bind(this);
        this.changediqminHandler = this.changediqminHandler.bind(this);
        this.changetgHandler = this.changetgHandler.bind(this);
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            WindGenType4IECService.getWindGenType4IECById(this.state.id).then( (res) =>{
                let windGenType4IEC = res.data;
                this.setState({
                    dipmax: windGenType4IEC.dipmax,
                    diqmax: windGenType4IEC.diqmax,
                    diqmin: windGenType4IEC.diqmin,
                    tg: windGenType4IEC.tg
                });
            });
        }        
    }
    saveOrUpdateWindGenType4IEC = (e) => {
        e.preventDefault();
        let windGenType4IEC = {
                windGenType4IECId: this.state.id,
                dipmax: this.state.dipmax,
                diqmax: this.state.diqmax,
                diqmin: this.state.diqmin,
                tg: this.state.tg
            };
        console.log('windGenType4IEC => ' + JSON.stringify(windGenType4IEC));

        // step 5
        if(this.state.id === '_add'){
            windGenType4IEC.windGenType4IECId=''
            WindGenType4IECService.createWindGenType4IEC(windGenType4IEC).then(res =>{
                this.props.history.push('/windGenType4IECs');
            });
        }else{
            WindGenType4IECService.updateWindGenType4IEC(windGenType4IEC).then( res => {
                this.props.history.push('/windGenType4IECs');
            });
        }
    }
    
    changedipmaxHandler= (event) => {
        this.setState({dipmax: event.target.value});
    }
    changediqmaxHandler= (event) => {
        this.setState({diqmax: event.target.value});
    }
    changediqminHandler= (event) => {
        this.setState({diqmin: event.target.value});
    }
    changetgHandler= (event) => {
        this.setState({tg: event.target.value});
    }

    cancel(){
        this.props.history.push('/windGenType4IECs');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add WindGenType4IEC</h3>
        }else{
            return <h3 className="text-center">Update WindGenType4IEC</h3>
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
                                            <label> dipmax: </label>
                                            #formFields( $attribute, 'create')
                                            <label> diqmax: </label>
                                            #formFields( $attribute, 'create')
                                            <label> diqmin: </label>
                                            #formFields( $attribute, 'create')
                                            <label> tg: </label>
                                            #formFields( $attribute, 'create')
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateWindGenType4IEC}>Save</button>
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

export default CreateWindGenType4IECComponent
