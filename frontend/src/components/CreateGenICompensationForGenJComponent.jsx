import React, { Component } from 'react'
import GenICompensationForGenJService from '../services/GenICompensationForGenJService';

class CreateGenICompensationForGenJComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
                rcij: '',
                xcij: ''
        }
        this.changercijHandler = this.changercijHandler.bind(this);
        this.changexcijHandler = this.changexcijHandler.bind(this);
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            GenICompensationForGenJService.getGenICompensationForGenJById(this.state.id).then( (res) =>{
                let genICompensationForGenJ = res.data;
                this.setState({
                    rcij: genICompensationForGenJ.rcij,
                    xcij: genICompensationForGenJ.xcij
                });
            });
        }        
    }
    saveOrUpdateGenICompensationForGenJ = (e) => {
        e.preventDefault();
        let genICompensationForGenJ = {
                genICompensationForGenJId: this.state.id,
                rcij: this.state.rcij,
                xcij: this.state.xcij
            };
        console.log('genICompensationForGenJ => ' + JSON.stringify(genICompensationForGenJ));

        // step 5
        if(this.state.id === '_add'){
            genICompensationForGenJ.genICompensationForGenJId=''
            GenICompensationForGenJService.createGenICompensationForGenJ(genICompensationForGenJ).then(res =>{
                this.props.history.push('/genICompensationForGenJs');
            });
        }else{
            GenICompensationForGenJService.updateGenICompensationForGenJ(genICompensationForGenJ).then( res => {
                this.props.history.push('/genICompensationForGenJs');
            });
        }
    }
    
    changercijHandler= (event) => {
        this.setState({rcij: event.target.value});
    }
    changexcijHandler= (event) => {
        this.setState({xcij: event.target.value});
    }

    cancel(){
        this.props.history.push('/genICompensationForGenJs');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add GenICompensationForGenJ</h3>
        }else{
            return <h3 className="text-center">Update GenICompensationForGenJ</h3>
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
                                            <label> rcij: </label>
                                            #formFields( $attribute, 'create')
                                            <label> xcij: </label>
                                            #formFields( $attribute, 'create')
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateGenICompensationForGenJ}>Save</button>
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

export default CreateGenICompensationForGenJComponent
