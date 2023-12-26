import React, { Component } from 'react'
import VCompIEEEType1Service from '../services/VCompIEEEType1Service';

class CreateVCompIEEEType1Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
                rc: '',
                tr: '',
                xc: ''
        }
        this.changercHandler = this.changercHandler.bind(this);
        this.changetrHandler = this.changetrHandler.bind(this);
        this.changexcHandler = this.changexcHandler.bind(this);
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            VCompIEEEType1Service.getVCompIEEEType1ById(this.state.id).then( (res) =>{
                let vCompIEEEType1 = res.data;
                this.setState({
                    rc: vCompIEEEType1.rc,
                    tr: vCompIEEEType1.tr,
                    xc: vCompIEEEType1.xc
                });
            });
        }        
    }
    saveOrUpdateVCompIEEEType1 = (e) => {
        e.preventDefault();
        let vCompIEEEType1 = {
                vCompIEEEType1Id: this.state.id,
                rc: this.state.rc,
                tr: this.state.tr,
                xc: this.state.xc
            };
        console.log('vCompIEEEType1 => ' + JSON.stringify(vCompIEEEType1));

        // step 5
        if(this.state.id === '_add'){
            vCompIEEEType1.vCompIEEEType1Id=''
            VCompIEEEType1Service.createVCompIEEEType1(vCompIEEEType1).then(res =>{
                this.props.history.push('/vCompIEEEType1s');
            });
        }else{
            VCompIEEEType1Service.updateVCompIEEEType1(vCompIEEEType1).then( res => {
                this.props.history.push('/vCompIEEEType1s');
            });
        }
    }
    
    changercHandler= (event) => {
        this.setState({rc: event.target.value});
    }
    changetrHandler= (event) => {
        this.setState({tr: event.target.value});
    }
    changexcHandler= (event) => {
        this.setState({xc: event.target.value});
    }

    cancel(){
        this.props.history.push('/vCompIEEEType1s');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add VCompIEEEType1</h3>
        }else{
            return <h3 className="text-center">Update VCompIEEEType1</h3>
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
                                            <label> rc: </label>
                                            #formFields( $attribute, 'create')
                                            <label> tr: </label>
                                            #formFields( $attribute, 'create')
                                            <label> xc: </label>
                                            #formFields( $attribute, 'create')
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateVCompIEEEType1}>Save</button>
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

export default CreateVCompIEEEType1Component
