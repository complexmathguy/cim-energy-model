import React, { Component } from 'react'
import PssSB4Service from '../services/PssSB4Service';

class UpdatePssSB4Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                kx: '',
                ta: '',
                tb: '',
                tc: '',
                td: '',
                te: '',
                tt: '',
                tx1: '',
                tx2: '',
                vsmax: '',
                vsmin: ''
        }
        this.updatePssSB4 = this.updatePssSB4.bind(this);

        this.changekxHandler = this.changekxHandler.bind(this);
        this.changetaHandler = this.changetaHandler.bind(this);
        this.changetbHandler = this.changetbHandler.bind(this);
        this.changetcHandler = this.changetcHandler.bind(this);
        this.changetdHandler = this.changetdHandler.bind(this);
        this.changeteHandler = this.changeteHandler.bind(this);
        this.changettHandler = this.changettHandler.bind(this);
        this.changetx1Handler = this.changetx1Handler.bind(this);
        this.changetx2Handler = this.changetx2Handler.bind(this);
        this.changevsmaxHandler = this.changevsmaxHandler.bind(this);
        this.changevsminHandler = this.changevsminHandler.bind(this);
    }

    componentDidMount(){
        PssSB4Service.getPssSB4ById(this.state.id).then( (res) =>{
            let pssSB4 = res.data;
            this.setState({
                kx: pssSB4.kx,
                ta: pssSB4.ta,
                tb: pssSB4.tb,
                tc: pssSB4.tc,
                td: pssSB4.td,
                te: pssSB4.te,
                tt: pssSB4.tt,
                tx1: pssSB4.tx1,
                tx2: pssSB4.tx2,
                vsmax: pssSB4.vsmax,
                vsmin: pssSB4.vsmin
            });
        });
    }

    updatePssSB4 = (e) => {
        e.preventDefault();
        let pssSB4 = {
            pssSB4Id: this.state.id,
            kx: this.state.kx,
            ta: this.state.ta,
            tb: this.state.tb,
            tc: this.state.tc,
            td: this.state.td,
            te: this.state.te,
            tt: this.state.tt,
            tx1: this.state.tx1,
            tx2: this.state.tx2,
            vsmax: this.state.vsmax,
            vsmin: this.state.vsmin
        };
        console.log('pssSB4 => ' + JSON.stringify(pssSB4));
        console.log('id => ' + JSON.stringify(this.state.id));
        PssSB4Service.updatePssSB4(pssSB4).then( res => {
            this.props.history.push('/pssSB4s');
        });
    }

    changekxHandler= (event) => {
        this.setState({kx: event.target.value});
    }
    changetaHandler= (event) => {
        this.setState({ta: event.target.value});
    }
    changetbHandler= (event) => {
        this.setState({tb: event.target.value});
    }
    changetcHandler= (event) => {
        this.setState({tc: event.target.value});
    }
    changetdHandler= (event) => {
        this.setState({td: event.target.value});
    }
    changeteHandler= (event) => {
        this.setState({te: event.target.value});
    }
    changettHandler= (event) => {
        this.setState({tt: event.target.value});
    }
    changetx1Handler= (event) => {
        this.setState({tx1: event.target.value});
    }
    changetx2Handler= (event) => {
        this.setState({tx2: event.target.value});
    }
    changevsmaxHandler= (event) => {
        this.setState({vsmax: event.target.value});
    }
    changevsminHandler= (event) => {
        this.setState({vsmin: event.target.value});
    }

    cancel(){
        this.props.history.push('/pssSB4s');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update PssSB4</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> kx: </label>
                                            #formFields( $attribute, 'update')
                                            <label> ta: </label>
                                            #formFields( $attribute, 'update')
                                            <label> tb: </label>
                                            #formFields( $attribute, 'update')
                                            <label> tc: </label>
                                            #formFields( $attribute, 'update')
                                            <label> td: </label>
                                            #formFields( $attribute, 'update')
                                            <label> te: </label>
                                            #formFields( $attribute, 'update')
                                            <label> tt: </label>
                                            #formFields( $attribute, 'update')
                                            <label> tx1: </label>
                                            #formFields( $attribute, 'update')
                                            <label> tx2: </label>
                                            #formFields( $attribute, 'update')
                                            <label> vsmax: </label>
                                            #formFields( $attribute, 'update')
                                            <label> vsmin: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updatePssSB4}>Save</button>
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

export default UpdatePssSB4Component
