import React, { Component } from 'react'
import Simple_FloatService from '../services/Simple_FloatService';

class CreateSimple_FloatComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
                value: ''
        }
        this.changevalueHandler = this.changevalueHandler.bind(this);
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            Simple_FloatService.getSimple_FloatById(this.state.id).then( (res) =>{
                let simple_Float = res.data;
                this.setState({
                    value: simple_Float.value
                });
            });
        }        
    }
    saveOrUpdateSimple_Float = (e) => {
        e.preventDefault();
        let simple_Float = {
                simple_FloatId: this.state.id,
                value: this.state.value
            };
        console.log('simple_Float => ' + JSON.stringify(simple_Float));

        // step 5
        if(this.state.id === '_add'){
            simple_Float.simple_FloatId=''
            Simple_FloatService.createSimple_Float(simple_Float).then(res =>{
                this.props.history.push('/simple_Floats');
            });
        }else{
            Simple_FloatService.updateSimple_Float(simple_Float).then( res => {
                this.props.history.push('/simple_Floats');
            });
        }
    }
    
    changevalueHandler= (event) => {
        this.setState({value: event.target.value});
    }

    cancel(){
        this.props.history.push('/simple_Floats');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add Simple_Float</h3>
        }else{
            return <h3 className="text-center">Update Simple_Float</h3>
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
                                            <label> value: </label>
                                            #formFields( $attribute, 'create')
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateSimple_Float}>Save</button>
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

export default CreateSimple_FloatComponent
