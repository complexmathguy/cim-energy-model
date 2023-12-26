import React, { Component } from 'react'
import PssIEEE1AService from '../services/PssIEEE1AService';

class UpdatePssIEEE1AComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                a1: '',
                a2: '',
                inputSignalType: '',
                ks: '',
                t1: '',
                t2: '',
                t3: '',
                t4: '',
                t5: '',
                t6: '',
                vrmax: '',
                vrmin: ''
        }
        this.updatePssIEEE1A = this.updatePssIEEE1A.bind(this);

        this.changea1Handler = this.changea1Handler.bind(this);
        this.changea2Handler = this.changea2Handler.bind(this);
        this.changeinputSignalTypeHandler = this.changeinputSignalTypeHandler.bind(this);
        this.changeksHandler = this.changeksHandler.bind(this);
        this.changet1Handler = this.changet1Handler.bind(this);
        this.changet2Handler = this.changet2Handler.bind(this);
        this.changet3Handler = this.changet3Handler.bind(this);
        this.changet4Handler = this.changet4Handler.bind(this);
        this.changet5Handler = this.changet5Handler.bind(this);
        this.changet6Handler = this.changet6Handler.bind(this);
        this.changevrmaxHandler = this.changevrmaxHandler.bind(this);
        this.changevrminHandler = this.changevrminHandler.bind(this);
    }

    componentDidMount(){
        PssIEEE1AService.getPssIEEE1AById(this.state.id).then( (res) =>{
            let pssIEEE1A = res.data;
            this.setState({
                a1: pssIEEE1A.a1,
                a2: pssIEEE1A.a2,
                inputSignalType: pssIEEE1A.inputSignalType,
                ks: pssIEEE1A.ks,
                t1: pssIEEE1A.t1,
                t2: pssIEEE1A.t2,
                t3: pssIEEE1A.t3,
                t4: pssIEEE1A.t4,
                t5: pssIEEE1A.t5,
                t6: pssIEEE1A.t6,
                vrmax: pssIEEE1A.vrmax,
                vrmin: pssIEEE1A.vrmin
            });
        });
    }

    updatePssIEEE1A = (e) => {
        e.preventDefault();
        let pssIEEE1A = {
            pssIEEE1AId: this.state.id,
            a1: this.state.a1,
            a2: this.state.a2,
            inputSignalType: this.state.inputSignalType,
            ks: this.state.ks,
            t1: this.state.t1,
            t2: this.state.t2,
            t3: this.state.t3,
            t4: this.state.t4,
            t5: this.state.t5,
            t6: this.state.t6,
            vrmax: this.state.vrmax,
            vrmin: this.state.vrmin
        };
        console.log('pssIEEE1A => ' + JSON.stringify(pssIEEE1A));
        console.log('id => ' + JSON.stringify(this.state.id));
        PssIEEE1AService.updatePssIEEE1A(pssIEEE1A).then( res => {
            this.props.history.push('/pssIEEE1As');
        });
    }

    changea1Handler= (event) => {
        this.setState({a1: event.target.value});
    }
    changea2Handler= (event) => {
        this.setState({a2: event.target.value});
    }
    changeinputSignalTypeHandler= (event) => {
        this.setState({inputSignalType: event.target.value});
    }
    changeksHandler= (event) => {
        this.setState({ks: event.target.value});
    }
    changet1Handler= (event) => {
        this.setState({t1: event.target.value});
    }
    changet2Handler= (event) => {
        this.setState({t2: event.target.value});
    }
    changet3Handler= (event) => {
        this.setState({t3: event.target.value});
    }
    changet4Handler= (event) => {
        this.setState({t4: event.target.value});
    }
    changet5Handler= (event) => {
        this.setState({t5: event.target.value});
    }
    changet6Handler= (event) => {
        this.setState({t6: event.target.value});
    }
    changevrmaxHandler= (event) => {
        this.setState({vrmax: event.target.value});
    }
    changevrminHandler= (event) => {
        this.setState({vrmin: event.target.value});
    }

    cancel(){
        this.props.history.push('/pssIEEE1As');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update PssIEEE1A</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> a1: </label>
                                            #formFields( $attribute, 'update')
                                            <label> a2: </label>
                                            #formFields( $attribute, 'update')
                                            <label> inputSignalType: </label>
                                            #formFields( $attribute, 'update')
                                            <label> ks: </label>
                                            #formFields( $attribute, 'update')
                                            <label> t1: </label>
                                            #formFields( $attribute, 'update')
                                            <label> t2: </label>
                                            #formFields( $attribute, 'update')
                                            <label> t3: </label>
                                            #formFields( $attribute, 'update')
                                            <label> t4: </label>
                                            #formFields( $attribute, 'update')
                                            <label> t5: </label>
                                            #formFields( $attribute, 'update')
                                            <label> t6: </label>
                                            #formFields( $attribute, 'update')
                                            <label> vrmax: </label>
                                            #formFields( $attribute, 'update')
                                            <label> vrmin: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updatePssIEEE1A}>Save</button>
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

export default UpdatePssIEEE1AComponent
