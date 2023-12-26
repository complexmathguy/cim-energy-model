import React, { Component } from 'react'
import WindGenType4IECService from '../services/WindGenType4IECService';

class UpdateWindGenType4IECComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                dipmax: '',
                diqmax: '',
                diqmin: '',
                tg: ''
        }
        this.updateWindGenType4IEC = this.updateWindGenType4IEC.bind(this);

        this.changedipmaxHandler = this.changedipmaxHandler.bind(this);
        this.changediqmaxHandler = this.changediqmaxHandler.bind(this);
        this.changediqminHandler = this.changediqminHandler.bind(this);
        this.changetgHandler = this.changetgHandler.bind(this);
    }

    componentDidMount(){
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

    updateWindGenType4IEC = (e) => {
        e.preventDefault();
        let windGenType4IEC = {
            windGenType4IECId: this.state.id,
            dipmax: this.state.dipmax,
            diqmax: this.state.diqmax,
            diqmin: this.state.diqmin,
            tg: this.state.tg
        };
        console.log('windGenType4IEC => ' + JSON.stringify(windGenType4IEC));
        console.log('id => ' + JSON.stringify(this.state.id));
        WindGenType4IECService.updateWindGenType4IEC(windGenType4IEC).then( res => {
            this.props.history.push('/windGenType4IECs');
        });
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

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update WindGenType4IEC</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> dipmax: </label>
                                            #formFields( $attribute, 'update')
                                            <label> diqmax: </label>
                                            #formFields( $attribute, 'update')
                                            <label> diqmin: </label>
                                            #formFields( $attribute, 'update')
                                            <label> tg: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateWindGenType4IEC}>Save</button>
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

export default UpdateWindGenType4IECComponent
