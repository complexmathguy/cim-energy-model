import React, { Component } from 'react'
import LoadGenericNonLinearService from '../services/LoadGenericNonLinearService';

class CreateLoadGenericNonLinearComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
                bs: '',
                bt: '',
                genericNonLinearLoadModelType: '',
                ls: '',
                lt: '',
                pt: '',
                qt: '',
                tp: '',
                tq: ''
        }
        this.changebsHandler = this.changebsHandler.bind(this);
        this.changebtHandler = this.changebtHandler.bind(this);
        this.changegenericNonLinearLoadModelTypeHandler = this.changegenericNonLinearLoadModelTypeHandler.bind(this);
        this.changelsHandler = this.changelsHandler.bind(this);
        this.changeltHandler = this.changeltHandler.bind(this);
        this.changeptHandler = this.changeptHandler.bind(this);
        this.changeqtHandler = this.changeqtHandler.bind(this);
        this.changetpHandler = this.changetpHandler.bind(this);
        this.changetqHandler = this.changetqHandler.bind(this);
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            LoadGenericNonLinearService.getLoadGenericNonLinearById(this.state.id).then( (res) =>{
                let loadGenericNonLinear = res.data;
                this.setState({
                    bs: loadGenericNonLinear.bs,
                    bt: loadGenericNonLinear.bt,
                    genericNonLinearLoadModelType: loadGenericNonLinear.genericNonLinearLoadModelType,
                    ls: loadGenericNonLinear.ls,
                    lt: loadGenericNonLinear.lt,
                    pt: loadGenericNonLinear.pt,
                    qt: loadGenericNonLinear.qt,
                    tp: loadGenericNonLinear.tp,
                    tq: loadGenericNonLinear.tq
                });
            });
        }        
    }
    saveOrUpdateLoadGenericNonLinear = (e) => {
        e.preventDefault();
        let loadGenericNonLinear = {
                loadGenericNonLinearId: this.state.id,
                bs: this.state.bs,
                bt: this.state.bt,
                genericNonLinearLoadModelType: this.state.genericNonLinearLoadModelType,
                ls: this.state.ls,
                lt: this.state.lt,
                pt: this.state.pt,
                qt: this.state.qt,
                tp: this.state.tp,
                tq: this.state.tq
            };
        console.log('loadGenericNonLinear => ' + JSON.stringify(loadGenericNonLinear));

        // step 5
        if(this.state.id === '_add'){
            loadGenericNonLinear.loadGenericNonLinearId=''
            LoadGenericNonLinearService.createLoadGenericNonLinear(loadGenericNonLinear).then(res =>{
                this.props.history.push('/loadGenericNonLinears');
            });
        }else{
            LoadGenericNonLinearService.updateLoadGenericNonLinear(loadGenericNonLinear).then( res => {
                this.props.history.push('/loadGenericNonLinears');
            });
        }
    }
    
    changebsHandler= (event) => {
        this.setState({bs: event.target.value});
    }
    changebtHandler= (event) => {
        this.setState({bt: event.target.value});
    }
    changegenericNonLinearLoadModelTypeHandler= (event) => {
        this.setState({genericNonLinearLoadModelType: event.target.value});
    }
    changelsHandler= (event) => {
        this.setState({ls: event.target.value});
    }
    changeltHandler= (event) => {
        this.setState({lt: event.target.value});
    }
    changeptHandler= (event) => {
        this.setState({pt: event.target.value});
    }
    changeqtHandler= (event) => {
        this.setState({qt: event.target.value});
    }
    changetpHandler= (event) => {
        this.setState({tp: event.target.value});
    }
    changetqHandler= (event) => {
        this.setState({tq: event.target.value});
    }

    cancel(){
        this.props.history.push('/loadGenericNonLinears');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add LoadGenericNonLinear</h3>
        }else{
            return <h3 className="text-center">Update LoadGenericNonLinear</h3>
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
                                            <label> bs: </label>
                                            #formFields( $attribute, 'create')
                                            <label> bt: </label>
                                            #formFields( $attribute, 'create')
                                            <label> genericNonLinearLoadModelType: </label>
                                            #formFields( $attribute, 'create')
                                            <label> ls: </label>
                                            #formFields( $attribute, 'create')
                                            <label> lt: </label>
                                            #formFields( $attribute, 'create')
                                            <label> pt: </label>
                                            #formFields( $attribute, 'create')
                                            <label> qt: </label>
                                            #formFields( $attribute, 'create')
                                            <label> tp: </label>
                                            #formFields( $attribute, 'create')
                                            <label> tq: </label>
                                            #formFields( $attribute, 'create')
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateLoadGenericNonLinear}>Save</button>
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

export default CreateLoadGenericNonLinearComponent
