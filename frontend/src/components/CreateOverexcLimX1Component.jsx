import React, { Component } from 'react'
import OverexcLimX1Service from '../services/OverexcLimX1Service';

class CreateOverexcLimX1Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
                efd1: '',
                efd2: '',
                efd3: '',
                efddes: '',
                efdrated: '',
                kmx: '',
                t1: '',
                t2: '',
                t3: '',
                vlow: ''
        }
        this.changeefd1Handler = this.changeefd1Handler.bind(this);
        this.changeefd2Handler = this.changeefd2Handler.bind(this);
        this.changeefd3Handler = this.changeefd3Handler.bind(this);
        this.changeefddesHandler = this.changeefddesHandler.bind(this);
        this.changeefdratedHandler = this.changeefdratedHandler.bind(this);
        this.changekmxHandler = this.changekmxHandler.bind(this);
        this.changet1Handler = this.changet1Handler.bind(this);
        this.changet2Handler = this.changet2Handler.bind(this);
        this.changet3Handler = this.changet3Handler.bind(this);
        this.changevlowHandler = this.changevlowHandler.bind(this);
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            OverexcLimX1Service.getOverexcLimX1ById(this.state.id).then( (res) =>{
                let overexcLimX1 = res.data;
                this.setState({
                    efd1: overexcLimX1.efd1,
                    efd2: overexcLimX1.efd2,
                    efd3: overexcLimX1.efd3,
                    efddes: overexcLimX1.efddes,
                    efdrated: overexcLimX1.efdrated,
                    kmx: overexcLimX1.kmx,
                    t1: overexcLimX1.t1,
                    t2: overexcLimX1.t2,
                    t3: overexcLimX1.t3,
                    vlow: overexcLimX1.vlow
                });
            });
        }        
    }
    saveOrUpdateOverexcLimX1 = (e) => {
        e.preventDefault();
        let overexcLimX1 = {
                overexcLimX1Id: this.state.id,
                efd1: this.state.efd1,
                efd2: this.state.efd2,
                efd3: this.state.efd3,
                efddes: this.state.efddes,
                efdrated: this.state.efdrated,
                kmx: this.state.kmx,
                t1: this.state.t1,
                t2: this.state.t2,
                t3: this.state.t3,
                vlow: this.state.vlow
            };
        console.log('overexcLimX1 => ' + JSON.stringify(overexcLimX1));

        // step 5
        if(this.state.id === '_add'){
            overexcLimX1.overexcLimX1Id=''
            OverexcLimX1Service.createOverexcLimX1(overexcLimX1).then(res =>{
                this.props.history.push('/overexcLimX1s');
            });
        }else{
            OverexcLimX1Service.updateOverexcLimX1(overexcLimX1).then( res => {
                this.props.history.push('/overexcLimX1s');
            });
        }
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
        this.props.history.push('/overexcLimX1s');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add OverexcLimX1</h3>
        }else{
            return <h3 className="text-center">Update OverexcLimX1</h3>
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
                                            <label> efd1: </label>
                                            #formFields( $attribute, 'create')
                                            <label> efd2: </label>
                                            #formFields( $attribute, 'create')
                                            <label> efd3: </label>
                                            #formFields( $attribute, 'create')
                                            <label> efddes: </label>
                                            #formFields( $attribute, 'create')
                                            <label> efdrated: </label>
                                            #formFields( $attribute, 'create')
                                            <label> kmx: </label>
                                            #formFields( $attribute, 'create')
                                            <label> t1: </label>
                                            #formFields( $attribute, 'create')
                                            <label> t2: </label>
                                            #formFields( $attribute, 'create')
                                            <label> t3: </label>
                                            #formFields( $attribute, 'create')
                                            <label> vlow: </label>
                                            #formFields( $attribute, 'create')
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateOverexcLimX1}>Save</button>
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

export default CreateOverexcLimX1Component
