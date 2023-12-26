import React, { Component } from 'react'
import PFVArType2Common1Service from '../services/PFVArType2Common1Service';

class UpdatePFVArType2Common1Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                j: '',
                ki: '',
                kp: '',
                max: '',
                ref: ''
        }
        this.updatePFVArType2Common1 = this.updatePFVArType2Common1.bind(this);

        this.changejHandler = this.changejHandler.bind(this);
        this.changekiHandler = this.changekiHandler.bind(this);
        this.changekpHandler = this.changekpHandler.bind(this);
        this.changemaxHandler = this.changemaxHandler.bind(this);
        this.changerefHandler = this.changerefHandler.bind(this);
    }

    componentDidMount(){
        PFVArType2Common1Service.getPFVArType2Common1ById(this.state.id).then( (res) =>{
            let pFVArType2Common1 = res.data;
            this.setState({
                j: pFVArType2Common1.j,
                ki: pFVArType2Common1.ki,
                kp: pFVArType2Common1.kp,
                max: pFVArType2Common1.max,
                ref: pFVArType2Common1.ref
            });
        });
    }

    updatePFVArType2Common1 = (e) => {
        e.preventDefault();
        let pFVArType2Common1 = {
            pFVArType2Common1Id: this.state.id,
            j: this.state.j,
            ki: this.state.ki,
            kp: this.state.kp,
            max: this.state.max,
            ref: this.state.ref
        };
        console.log('pFVArType2Common1 => ' + JSON.stringify(pFVArType2Common1));
        console.log('id => ' + JSON.stringify(this.state.id));
        PFVArType2Common1Service.updatePFVArType2Common1(pFVArType2Common1).then( res => {
            this.props.history.push('/pFVArType2Common1s');
        });
    }

    changejHandler= (event) => {
        this.setState({j: event.target.value});
    }
    changekiHandler= (event) => {
        this.setState({ki: event.target.value});
    }
    changekpHandler= (event) => {
        this.setState({kp: event.target.value});
    }
    changemaxHandler= (event) => {
        this.setState({max: event.target.value});
    }
    changerefHandler= (event) => {
        this.setState({ref: event.target.value});
    }

    cancel(){
        this.props.history.push('/pFVArType2Common1s');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update PFVArType2Common1</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> j: </label>
                                            #formFields( $attribute, 'update')
                                            <label> ki: </label>
                                            #formFields( $attribute, 'update')
                                            <label> kp: </label>
                                            #formFields( $attribute, 'update')
                                            <label> max: </label>
                                            #formFields( $attribute, 'update')
                                            <label> ref: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updatePFVArType2Common1}>Save</button>
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

export default UpdatePFVArType2Common1Component
