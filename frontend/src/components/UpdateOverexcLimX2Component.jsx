import React, { Component } from 'react'
import OverexcLimX2Service from '../services/OverexcLimX2Service';

class UpdateOverexcLimX2Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                efd1: '',
                efd2: '',
                efd3: '',
                efddes: '',
                efdrated: '',
                kmx: '',
                m: '',
                t1: '',
                t2: '',
                t3: '',
                vlow: ''
        }
        this.updateOverexcLimX2 = this.updateOverexcLimX2.bind(this);

        this.changeefd1Handler = this.changeefd1Handler.bind(this);
        this.changeefd2Handler = this.changeefd2Handler.bind(this);
        this.changeefd3Handler = this.changeefd3Handler.bind(this);
        this.changeefddesHandler = this.changeefddesHandler.bind(this);
        this.changeefdratedHandler = this.changeefdratedHandler.bind(this);
        this.changekmxHandler = this.changekmxHandler.bind(this);
        this.changemHandler = this.changemHandler.bind(this);
        this.changet1Handler = this.changet1Handler.bind(this);
        this.changet2Handler = this.changet2Handler.bind(this);
        this.changet3Handler = this.changet3Handler.bind(this);
        this.changevlowHandler = this.changevlowHandler.bind(this);
    }

    componentDidMount(){
        OverexcLimX2Service.getOverexcLimX2ById(this.state.id).then( (res) =>{
            let overexcLimX2 = res.data;
            this.setState({
                efd1: overexcLimX2.efd1,
                efd2: overexcLimX2.efd2,
                efd3: overexcLimX2.efd3,
                efddes: overexcLimX2.efddes,
                efdrated: overexcLimX2.efdrated,
                kmx: overexcLimX2.kmx,
                m: overexcLimX2.m,
                t1: overexcLimX2.t1,
                t2: overexcLimX2.t2,
                t3: overexcLimX2.t3,
                vlow: overexcLimX2.vlow
            });
        });
    }

    updateOverexcLimX2 = (e) => {
        e.preventDefault();
        let overexcLimX2 = {
            overexcLimX2Id: this.state.id,
            efd1: this.state.efd1,
            efd2: this.state.efd2,
            efd3: this.state.efd3,
            efddes: this.state.efddes,
            efdrated: this.state.efdrated,
            kmx: this.state.kmx,
            m: this.state.m,
            t1: this.state.t1,
            t2: this.state.t2,
            t3: this.state.t3,
            vlow: this.state.vlow
        };
        console.log('overexcLimX2 => ' + JSON.stringify(overexcLimX2));
        console.log('id => ' + JSON.stringify(this.state.id));
        OverexcLimX2Service.updateOverexcLimX2(overexcLimX2).then( res => {
            this.props.history.push('/overexcLimX2s');
        });
    }

    changeefd1Handler= (event) => {
        this.setState({efd1: event.target.value});
    }
    changeefd2Handler= (event) => {
        this.setState({efd2: event.target.value});
    }
    changeefd3Handler= (event) => {
        this.setState({efd3: event.target.value});
    }
    changeefddesHandler= (event) => {
        this.setState({efddes: event.target.value});
    }
    changeefdratedHandler= (event) => {
        this.setState({efdrated: event.target.value});
    }
    changekmxHandler= (event) => {
        this.setState({kmx: event.target.value});
    }
    changemHandler= (event) => {
        this.setState({m: event.target.value});
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
    changevlowHandler= (event) => {
        this.setState({vlow: event.target.value});
    }

    cancel(){
        this.props.history.push('/overexcLimX2s');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update OverexcLimX2</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> efd1: </label>
                                            #formFields( $attribute, 'update')
                                            <label> efd2: </label>
                                            #formFields( $attribute, 'update')
                                            <label> efd3: </label>
                                            #formFields( $attribute, 'update')
                                            <label> efddes: </label>
                                            #formFields( $attribute, 'update')
                                            <label> efdrated: </label>
                                            #formFields( $attribute, 'update')
                                            <label> kmx: </label>
                                            #formFields( $attribute, 'update')
                                            <label> m: </label>
                                            #formFields( $attribute, 'update')
                                            <label> t1: </label>
                                            #formFields( $attribute, 'update')
                                            <label> t2: </label>
                                            #formFields( $attribute, 'update')
                                            <label> t3: </label>
                                            #formFields( $attribute, 'update')
                                            <label> vlow: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateOverexcLimX2}>Save</button>
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

export default UpdateOverexcLimX2Component
